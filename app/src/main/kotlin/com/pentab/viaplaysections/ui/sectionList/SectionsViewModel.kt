package com.pentab.viaplaysections.ui.sectionList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pentab.viaplaysections.data.entities.Section
import com.pentab.viaplaysections.data.repo.SectionRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/*
 * ViewModel for the [SectionsActivity] screen.
 * The ViewModel works with the [SectionRepository] to get the data.
 */
class SectionsViewModel(private val repository: SectionRepository) : ViewModel() {

    private val sections: MutableLiveData<List<Section>> = MutableLiveData()
    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val errorMessage: MutableLiveData<String> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    init {
        this.isLoading.value = false
    }

    fun requestSections() {
        compositeDisposable.add(
            repository.getSections()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { this.isLoading.value = true }
                .doOnComplete { this.isLoading.value = false }
                .doOnError { this.isLoading.value = false }
                .subscribe(
                    { sections.value = it },
                    { errorMessage.value = it.message }
                )
        )
    }

    fun getLoading(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }

    fun getSections(): MutableLiveData<List<Section>> {
        return sections
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}