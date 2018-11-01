package com.pentab.viaplaysections.data.db

import com.pentab.viaplaysections.data.entities.Section
import androidx.room.*

/**
 * Room data access object for accessing the [Section] table.
 */
@Dao
interface SectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSections(sections: List<Section>)

    @Query("SELECT * FROM section ")
    fun getSections(): List<Section>

    @Delete
    fun clearSections(sections: List<Section>)

}