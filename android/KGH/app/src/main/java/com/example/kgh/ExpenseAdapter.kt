package com.example.kgh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kgh.databinding.ItemExpenseBinding

class ExpenseAdapter(
    private var list: List<Expense>,
    private val onDelete: (Expense) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.Holder>() {

    inner class Holder(val binding: ItemExpenseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Expense) {
            binding.tvName.text = item.name
            binding.tvAmount.text = "${item.amount}원"
            binding.tvDate.text = item.date
            binding.tvCategory.text = item.category
            binding.btnDelete.setOnClickListener { onDelete(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(list[position])

    fun update(newList: List<Expense>) {
        list = newList
        notifyDataSetChanged()
    }
}