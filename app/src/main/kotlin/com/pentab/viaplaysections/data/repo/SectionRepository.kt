package com.pentab.viaplaysections.data.repo

import com.pentab.viaplaysections.data.api.ViaPlayService
import com.pentab.viaplaysections.data.db.SectionLocalCache
import com.pentab.viaplaysections.data.entities.Section
import com.pentab.viaplaysections.data.entities.SectionDetails
import com.pentab.viaplaysections.data.entities.ViaplaySection
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Repository class that works with remote data source and local cache.
 */
class SectionRepository(
    private val service: ViaPlayService,
    private val cache: SectionLocalCache
) {

    /**
     * This function gets the sections from the api and save it
     * in the db, so whenever there is no internet it gets the data from
     * the db.
     */
    fun getSections(): Observable<List<Section>> {
        return service.getSections()
            .flattenAsObservable { it -> it.links.sections }
            .map { it -> formatSection(it) }
            .flatMap { it -> getSectionDetails(it) }
            .toList()
            .onErrorResumeNext {
                val sections = cache.getSections()
                Single.just(sections)
            }.toObservable()
            .doOnNext {
                val currentSections = cache.getSections()
                cache.clearSections(currentSections)
                cache.saveSections(it)
            }
    }

    private fun getSectionDetails(section: Section): Observable<Section> {
        //Hard coded suffix {?dtg} for demo only
        return service.getSectionDetails(section.href.removeSuffix("{?dtg}"))
            .toObservable()
            .map { it -> addDetailsToSection(section, it) }
    }

    private fun formatSection(data: ViaplaySection): Section {
        return Section(data.id, data.href, data.title)
    }

    private fun addDetailsToSection(section: Section, sectionDetails: SectionDetails): Section {
        section.sectionTitle = sectionDetails.title
        section.sectionDesc = sectionDetails.description
        return section
    }

}