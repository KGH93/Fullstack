package com.example.kgh

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense_table")
    fun getAll(): LiveData<List<Expense>>

    @Query("SELECT * FROM expense_table WHERE date = :date")
    fun getByDate(date: String): LiveData<List<Expense>>

    @Query("SELECT * FROM expense_table WHERE category = :category")
    fun getByCategory(category: String): LiveData<List<Expense>>

    @Query("SELECT * FROM expense_table WHERE date = :date AND category = :category")
    fun getByDateAndCategory(date: String, category: String): LiveData<List<Expense>>

    @Insert
    suspend fun insert(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)
}
