package com.example.rssfeedparsing.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rssfeedparsing.databinding.RowBinding
import com.example.rssfeedparsing.model.Tweet

class MyAdapter(var tweets: ArrayList<Tweet>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    class MyHolder(val binding: RowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val tweet = tweets[position]
        holder.binding.apply {
            titleTv.text = tweet.title
        }
    }

    override fun getItemCount(): Int = tweets.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: ArrayList<Tweet>){
        tweets = newList
        notifyDataSetChanged()
    }
}