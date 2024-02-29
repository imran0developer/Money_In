package com.app.moneyin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.moneyin.pojo.Spending
import com.app.moneyin.utils.Constants

@Database(entities = [Spending::class], version = 1, exportSchema = false)
abstract class SpendingDatabase : RoomDatabase() {

    abstract fun spendingDao(): SpendingDao

    companion object {
        @Volatile
        private var INSTANCE: SpendingDatabase? = null

        fun getDatabase(context: Context): SpendingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpendingDatabase::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
