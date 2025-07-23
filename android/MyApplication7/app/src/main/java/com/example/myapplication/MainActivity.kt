package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: EmotionViewModel by viewModels()
        // 감정 데이터관리, 데이터가 사라지지 않게 유지

    //초기설정 수정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //activity_main.xml 레이아웃으로 설정

        val adapter = EmotionAdapter { emotion -> viewModel.deleteEmotion(emotion) }
        binding.rvEmotions.layoutManager = LinearLayoutManager(this)
        binding.rvEmotions.adapter = adapter

        viewModel.emotions.observe(this) {
            adapter.submitList(it)
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddEmotionActivity::class.java))
        }
    }
}