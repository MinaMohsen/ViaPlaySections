package com.pentab.viaplaysections.di.component.view

import com.pentab.viaplaysections.di.scope.ActivityScope
import com.pentab.viaplaysections.di.view.SectionsModule
import com.pentab.viaplaysections.ui.sectionList.SectionsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SectionsModule::class))
interface SectionsComponent {

    fun inject(sectionsActivity: SectionsActivity)

}