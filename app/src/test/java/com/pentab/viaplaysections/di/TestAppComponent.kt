package com.pentab.viaplaysections.di

import com.pentab.viaplaysections.base.BaseTest
import com.pentab.viaplaysections.di.module.NetModule
import com.pentab.viaplaysections.di.module.RepositoryModule
import com.pentab.viaplaysections.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetModule::class, RepositoryModule::class,
        ViewModelModule::class, TestRxJavaModule::class]
)
interface TestAppComponent {
    fun inject(baseTest: BaseTest)
}