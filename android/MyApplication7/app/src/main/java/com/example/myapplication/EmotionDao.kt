package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.Emotion

@Dao
interface EmotionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(emotion: Emotion)

    @Query("SELECT * FROM emotion_table ORDER BY date DESC")
    fun getAll(): LiveData<List<Emotion>>

    @Delete
    suspend fun delete(emotion: Emotion)
}