package com.example.myapplication13

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import androidx.lifecycle.LiveData

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expense_table ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Query("SELECT SUM(amount) FROM expense_table WHERE date = :today")
    fun getTodayTotal(today: String): LiveData<Int>
}

//Room Database와 직접 통신하는 인터페이스
//데이터를 삽입, 삭제, 조회하는 sql 쿼리 정의