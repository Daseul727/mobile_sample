package com.example.slider_mobile.text

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slider_mobile.databinding.ListitemTextBinding

data class Data(
    var title: String,
    var content: String
)

class TextViewPagerAdapter(private val list: ArrayList<Data>) : RecyclerView.Adapter<TextViewPagerAdapter.TextViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding = ListitemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        //holder.bind(list[position])
        holder.bind(list[position % list.size])
    }

    override fun getItemCount(): Int {
        //return list.size
        return Int.MAX_VALUE
    }

    inner class TextViewHolder(
        private val binding:ListitemTextBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            with(binding) {
                tvFaqTitle.text = data.title
                tvFaqContent.text = data.content
            }
        }
    }

}