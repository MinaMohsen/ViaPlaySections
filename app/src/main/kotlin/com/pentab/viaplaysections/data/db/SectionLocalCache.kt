package com.pentab.viaplaysections.data.db

import com.pentab.viaplaysections.data.entities.Section

/**
 * Class that handles the DAO local data source.
 */
class SectionLocalCache(private val sectionDao: SectionDao) {

    fun saveSections(sections: List<Section>) {
        sectionDao.saveSections(sections)
    }

    fun clearSections(sections: List<Section>) {
        sectionDao.clearSections(sections)
    }

    fun getSections(): List<Section> {
        return sectionDao.getSections()
    }
}