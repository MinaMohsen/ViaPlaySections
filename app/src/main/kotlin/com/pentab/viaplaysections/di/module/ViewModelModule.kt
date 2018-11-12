package com.pentab.viaplaysections.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pentab.viaplaysections.di.module.ViewModelKey
import com.pentab.viaplaysections.ui.ViewModelFactory
import com.pentab.viaplaysections.ui.sectionList.SectionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SectionsViewModel::class)
    internal abstract fun postMainViewModel(viewModel: SectionsViewModel)
            : ViewModel


}