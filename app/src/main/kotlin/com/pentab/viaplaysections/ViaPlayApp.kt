package com.pentab.viaplaysections

import android.app.Application
import com.pentab.viaplaysections.di.component.AppComponent
import com.pentab.viaplaysections.di.component.DaggerAppComponent
import com.pentab.viaplaysections.di.module.NetModule
import com.pentab.viaplaysections.di.module.RepositoryModule
import com.pentab.viaplaysections.di.module.RxJavaModule

open class ViaPlayApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    protected open fun initDagger(): AppComponent
            = DaggerAppComponent.builder()
        .netModule(NetModule(BuildConfig.baseURL))
        .repositoryModule(RepositoryModule(this))
        .rxJavaModule(RxJavaModule())
        .build()

}