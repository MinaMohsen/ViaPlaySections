package com.pentab.viaplaysections.ui.sectionList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pentab.viaplaysections.data.entities.Section
import com.pentab.viaplaysections.data.repo.SectionRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named
import com.pentab.viaplaysections.di.SUBSCRIBER_ON
import com.pentab.viaplaysections.di.OBSERVER_ON


/*
 * ViewModel for the [SectionsActivity] screen.
 * The ViewModel works with the [SectionRepository] to get the data.
 */
class SectionsViewModel @Inject constructor(
    private val repository: SectionRepository,
    @param:Named(SUBSCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler
) : ViewModel() {

    private val sections: MutableLiveData<List<Section>> = MutableLiveData()
    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    init {
        this.isLoading.value = false
    }

    fun requestSections() {
        compositeDisposable.add(
            repository.getSections()
                .subscribeOn(subscriberOn)
                .observeOn(observerOn)
                .doOnSubscribe { this.isLoading.value = true }
                .doOnComplete { this.isLoading.value = false }
                .doOnError { this.isLoading.value = false }
                .subscribe { sections.value = it }
        )
    }

    fun getLoading(): MutableLiveData<Boolean> {
        return isLoading
    }


    fun getSections(): MutableLiveData<List<Section>> {
        return sections
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}