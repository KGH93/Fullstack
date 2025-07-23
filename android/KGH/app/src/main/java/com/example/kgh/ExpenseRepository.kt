package com.example.kgh

class ExpenseRepository(private val dao: ExpenseDao) {
    val allExpenses = dao.getAll()
    suspend fun insert(expense: Expense) = dao.insert(expense)
    suspend fun delete(expense: Expense) = dao.delete(expense)
}