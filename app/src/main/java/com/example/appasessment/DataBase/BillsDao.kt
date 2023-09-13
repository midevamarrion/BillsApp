package com.example.appasessment.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appasessment.models.Bill

@Dao
interface BillsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBill(bill: Bill)

    @Query("SELECT * FROM BILLS WHERE frequency=:freq")
    fun getRecurringBills(freq:String):List<Bill>
}