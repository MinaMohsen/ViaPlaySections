package com.pentab.viaplaysections.di.component

import com.pentab.viaplaysections.di.module.NetModule
import com.pentab.viaplaysections.di.module.RepositoryModule
import com.pentab.viaplaysections.di.module.RxJavaModule
import com.pentab.viaplaysections.di.module.ViewModelModule
import com.pentab.viaplaysections.di.component.view.SectionsComponent
import com.pentab.viaplaysections.di.module.view.SectionsModule
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