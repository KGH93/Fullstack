package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.EmotionDatabase
import com.example.myapplication.Emotion
import kotlinx.coroutines.launch
// 데이터 관리: emotion 객체를 저장, 불러오고, 삭제 하는 등의 데이터베이스 작업
class EmotionViewModel(application: Application) : AndroidViewModel(application) {
    private val emotionDao = EmotionDatabase.getDatabase(application).emotionDao()
    val emotions: LiveData<List<Emotion>> = emotionDao.getAll()

    fun addEmotion(emotion: Emotion) = viewModelScope.launch {
        emotionDao.insert(emotion)
    } //데이터 추가

    fun deleteEmotion(emotion: Emotion) = viewModelScope.launch {
        emotionDao.delete(emotion)
    } //데이터 삭제
}