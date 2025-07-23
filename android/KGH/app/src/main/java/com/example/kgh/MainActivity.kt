package com.example.kgh

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels // ✅ 수정 완료
import androidx.appcompat.app.AppCompatActivity // ✅ 수정 완료
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kgh.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExpenseViewModel by viewModels()
    private lateinit var adapter: ExpenseAdapter
    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 날짜 선택
        binding.tvDate.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                selectedDate = "$y-${m + 1}-$d"
                binding.tvDate.text = selectedDate
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Spinner 설정
        val categories = listOf("전체", "식비", "교통비", "쇼핑", "기타")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)
        binding.spinnerCategory.adapter = spinnerAdapter

        // RecyclerView 설정
        adapter = ExpenseAdapter(emptyList()) { viewModel.delete(it) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // LiveData observe
        viewModel.allExpenses.observe(this) {
            adapter.update(it)
            val total = it.sumOf { e -> e.amount }
            binding.tvTotal.text = "총합: ${total}원"
        }

        // 등록
        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString().toIntOrNull() ?: 0
            val category = binding.spinnerCategory.selectedItem.toString()

            if (name.isNotBlank() && selectedDate.isNotEmpty()) {
                val expense = Expense(name = name, amount = amount, date = selectedDate, category = category)
                viewModel.insert(expense)
            }
        }

        //필터 적용 버튼 기능
        binding.btnFilter.setOnClickListener {
            val date = selectedDate
            val category = binding.spinnerCategory.selectedItem.toString()

            val filteredLiveData = when {
                date.isNotEmpty() && category != "전체" -> viewModel.getByDateAndCategory(date, category)
                date.isNotEmpty() -> viewModel.getByDate(date)
                category != "전체" -> viewModel.getByCategory(category)
                else -> viewModel.allExpenses
            }

            filteredLiveData.observe(this) { filteredList ->
                adapter.update(filteredList)
                val total = filteredList.sumOf { it.amount }
                binding.tvTotal.text = "총합: ${total}원"
            }
        }

        //필터 해체 버튼 기능
        binding.btnClearFilter.setOnClickListener {
            selectedDate = ""
            binding.tvDate.text = "날짜 선택" // 텍스트 초기화

            binding.spinnerCategory.setSelection(0) // "전체" 항목으로 Spinner 초기화

            // 전체 목록 다시 불러오기
            viewModel.allExpenses.observe(this) { list ->
                adapter.update(list)
                val total = list.sumOf { it.amount }
                binding.tvTotal.text = "총합: ${total}원"
            }
        }

    }
}
