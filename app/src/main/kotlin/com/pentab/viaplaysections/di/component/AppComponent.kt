package com.pentab.viaplaysections.di.component

import com.pentab.viaplaysections.di.NetModule
import com.pentab.viaplaysections.di.RepositoryModule
import com.pentab.viaplaysections.di.RxJavaModule
import com.pentab.viaplaysections.di.ViewModelModule
import com.pentab.viaplaysections.di.component.view.SectionsComponent
import com.pentab.viaplaysections.di.view.SectionsModule
import com.pentab.viaplaysections.ui.sectionList.SectionsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetModule::class, RepositoryModule::class,
        ViewModelModule::class, RxJavaModule::class]
)
interface AppComponent {
//    fun inject(sectionsActivity: SectionsActivity)

    fun add(sectionsModule: SectionsModule): SectionsComponent

}