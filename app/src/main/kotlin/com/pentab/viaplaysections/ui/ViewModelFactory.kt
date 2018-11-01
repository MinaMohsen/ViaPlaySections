package com.pentab.viaplaysections.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pentab.viaplaysections.data.repo.SectionRepository
import com.pentab.viaplaysections.ui.sectionList.SectionsViewModel

/**
 * Created by Mina Mohsen on 1/11/2018.
 *
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: SectionRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SectionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SectionsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
