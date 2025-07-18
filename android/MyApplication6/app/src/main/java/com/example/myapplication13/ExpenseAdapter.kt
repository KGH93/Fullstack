package com.example.myapplication13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter : ListAdapter<Expense, ExpenseAdapter.ExpenseViewHolder>(DiffCallback()) {

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvAmount = itemView.findViewById<TextView>(R.id.tv_amount)
        private val tvCategory = itemView.findViewById<TextView>(R.id.tv_category)
        private val tvDate = itemView.findViewById<TextView>(R.id.tv_date)

        fun bind(expense: Expense) {
            tvTitle.text = expense.title
            tvAmount.text = "₩ ${expense.amount}"
            tvCategory.text = expense.category
            tvDate.text = expense.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem == newItem
        }
    }
}

//RecycleView 어댑터 클래스
//지출목록을 화면에 보여줄 때 각 아이템 뷰를 생성하고 바인딩함 
//예: 날짜별 지출 내역 목록 출력