package com.mili.holidays.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mili.features.countries.data.local.CountryDao
import com.mili.features.countries.data.local.CountryEntity
import com.mili.features.holidays.data.local.HolidayDao
import com.mili.features.holidays.data.local.HolidayEntity


@Database(
    entities = [HolidayEntity::class, CountryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {


    abstract fun countryDao(): CountryDao
    abstract fun holidayDao(): HolidayDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}