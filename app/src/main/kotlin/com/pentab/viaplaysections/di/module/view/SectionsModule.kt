package com.pentab.viaplaysections.di.module.view

import com.pentab.viaplaysections.di.scope.ActivityScope
import com.pentab.viaplaysections.ui.sectionList.SectionsAdapter
import dagger.Module
import dagger.Provides

@Module
class SectionsModule {

    @Provides
    @ActivityScope
    internal fun provideSectionsAdapter(): SectionsAdapter = SectionsAdapter()

}