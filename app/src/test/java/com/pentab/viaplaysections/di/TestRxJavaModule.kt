package com.pentab.viaplaysections.di

import com.pentab.viaplaysections.di.module.OBSERVER_ON
import com.pentab.viaplaysections.di.module.SUBSCRIBER_ON
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class TestRxJavaModule {

    @Provides
    @Named(SUBSCRIBER_ON)
    @Singleton
    fun provideSubscriberOn(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(OBSERVER_ON)
    @Singleton
    fun provideObserverOn(): Scheduler = AndroidSchedulers.mainThread()
}