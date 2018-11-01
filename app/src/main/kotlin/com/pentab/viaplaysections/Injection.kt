package com.pentab.viaplaysections

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.pentab.viaplaysections.data.api.ViaPlayServiceFactory
import com.pentab.viaplaysections.data.db.SectionDatabase
import com.pentab.viaplaysections.data.db.SectionLocalCache
import com.pentab.viaplaysections.data.repo.SectionRepository
import com.pentab.viaplaysections.ui.ViewModelFactory

/**
 * Created by Mina Mohsen on 1/11/2018.
 *
 * Class that handles object creation.
 * Like this, objects can be passed as parameters in the constructors and then replaced for
 * testing, where needed.
 * We can replace this with any other framework for DI like Dagger 2 or Koin , I use this only for demo
 */
object Injection {

    /**
     * Creates an instance of [SectionLocalCache] based on the database DAO.
     */
    private fun provideCache(context: Context): SectionLocalCache {
        val database = SectionDatabase.getInstance(context)
        return SectionLocalCache(database.sectionsDao())
    }

    /**
     * Creates an instance of [SectionRepository] based on the [ViaPlayService] and a
     * [SectionLocalCache]
     */
    private fun provideSectionRepository(context: Context): SectionRepository {
        return SectionRepository(
            ViaPlayServiceFactory.getViaPlayService(),
            provideCache(context)
        )
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideSectionRepository(context))
    }

}
