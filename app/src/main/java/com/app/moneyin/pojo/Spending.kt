package com.app.moneyin.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.moneyin.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class Spending(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val money: Double,
    val reason: String,
    val category: String,
    val date: Long // Date in milliseconds
)