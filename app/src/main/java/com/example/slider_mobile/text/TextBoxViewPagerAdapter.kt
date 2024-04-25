package com.example.slider_mobile.text

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slider_mobile.databinding.ListitemTextBoxBinding


class TextBoxViewPagerAdapter(private val list: ArrayList<Data>) : RecyclerView.Adapter<TextBoxViewPagerAdapter.TextBoxViewPagerAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextBoxViewPagerAdapter {
        val binding =
            ListitemTextBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextBoxViewPagerAdapter(binding)
    }

    override fun onBindViewHolder(holder: TextBoxViewPagerAdapter, position: Int) {
        //holder.bind(list[position])
        holder.bind(list[position % list.size])
    }

    override fun getItemCount(): Int {
        //return list.size
        return Int.MAX_VALUE
    }

    inner class TextBoxViewPagerAdapter(
        private val binding: ListitemTextBoxBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            with(binding) {
                tvFaqTitle.text = data.title
                tvFaqContent.text = data.content
            }
        }
    }

}