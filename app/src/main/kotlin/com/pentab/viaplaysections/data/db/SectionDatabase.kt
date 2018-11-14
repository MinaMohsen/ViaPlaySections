package com.pentab.viaplaysections.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pentab.viaplaysections.data.entities.Section

/**
 * Database schema that holds the list of sections.
 */
@Database(
    entities = [Section::class],
    version = 1,
    exportSchema = false)
abstract class SectionDatabase : RoomDatabase() {

    abstract fun sectionsDao(): SectionDao

    companion object {

        @Volatile
        private var INSTANCE: SectionDatabase? = null

        fun getInstance(context: Context): SectionDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            // allow main thread queries only for testing
            Room.databaseBuilder(
                context.applicationContext,
                SectionDatabase::class.java,
                "Viaplay.db"
            ).allowMainThreadQueries().build()
    }
}