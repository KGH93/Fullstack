package com.example.kgh

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = ExpenseDatabase.getDatabase(application).expenseDao()

    val allExpenses: LiveData<List<Expense>> = dao.getAll()

    fun getByDate(date: String): LiveData<List<Expense>> = dao.getByDate(date)
    fun getByCategory(category: String): LiveData<List<Expense>> = dao.getByCategory(category)
    fun getByDateAndCategory(date: String, category: String): LiveData<List<Expense>> = dao.getByDateAndCategory(date, category)

    fun insert(expense: Expense) = viewModelScope.launch {
        dao.insert(expense)
    }

    fun delete(expense: Expense) = viewModelScope.launch {
        dao.delete(expense)
    }
}
