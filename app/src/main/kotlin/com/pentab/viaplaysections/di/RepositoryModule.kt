package com.pentab.viaplaysections.di

import android.content.Context
import com.pentab.viaplaysections.data.api.ViaPlayService
import com.pentab.viaplaysections.data.db.SectionDao
import com.pentab.viaplaysections.data.db.SectionDatabase
import com.pentab.viaplaysections.data.db.SectionLocalCache
import com.pentab.viaplaysections.data.repo.SectionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(val context: Context) {

    @Provides
    @Singleton
    fun provideSectionsRepository(
        localCache: SectionLocalCache,
        viaPlayService: ViaPlayService
    ) = SectionRepository(viaPlayService, localCache)

    @Provides
    fun provideDatabase(): SectionDatabase =
        SectionDatabase.getInstance(context)

    @Provides
    fun provideDao(db: SectionDatabase): SectionDao = db.sectionsDao()

    @Provides
    fun provideLocalCache(dao: SectionDao): SectionLocalCache =
        SectionLocalCache(dao)


}
