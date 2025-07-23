package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemEmotionBinding
import com.example.myapplication.Emotion

// EmotionAdapter 는 감정 데이터와 RecycleView의 시각적 표현 사이를 연결
// RecycleView 가 각 항목뷰를 재활용 할 수 있도록 EmotionViewHolder를 생성관리
class EmotionAdapter(
    private val onDelete: (Emotion) -> Unit
) : ListAdapter<Emotion, EmotionAdapter.EmotionViewHolder>(DiffCallback) {
// 삭제버튼이 클릭 되었을때 EmotionViewModel에게 해당 감정을 삭제하라는 ondelete 함수제공

    //항목 업데이트 최적화
    inner class EmotionViewHolder(private val binding: ItemEmotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(emotion: Emotion) {
            binding.tvDate.text = emotion.date
            binding.tvFeeling.text = emotion.feeling
            binding.tvContent.text = emotion.content
            binding.btnDelete.setOnClickListener { onDelete(emotion) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmotionViewHolder {
        val binding = ItemEmotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmotionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Emotion>() {
            override fun areItemsTheSame(oldItem: Emotion, newItem: Emotion) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Emotion, newItem: Emotion) = oldItem == newItem
        }
    }
}