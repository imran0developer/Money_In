package com.app.moneyin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.moneyin.pojo.Spending
import com.app.moneyin.utils.Constants

@Dao
interface SpendingDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spending: Spending)

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    suspend fun getAllSpendings(): List<Spending>

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE reason = :reason")
    suspend fun getSpendingsByReason(reason: String): List<Spending>

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE category = :category")
    suspend fun getSpendingsByCategory(category: String): List<Spending>

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE money <= :maxMoney")
    suspend fun getSpendingsByMoney(maxMoney: Double): List<Spending>

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getSpendingsByDateRange(startDate: Long, endDate: Long): List<Spending>
}
