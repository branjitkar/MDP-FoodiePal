package com.miu.foodieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.foodieapp.R
import com.miu.foodieapp.model.Blog

class BlogAdapter(private val blogList: List<Blog>) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blogItemTitle: TextView = itemView.findViewById(R.id.blogItemTitle)
        val blogItemAuthor: TextView = itemView.findViewById(R.id.blogItemAuthor)
        val blogItemContent: TextView = itemView.findViewById(R.id.blogItemContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.blog_list_item, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentBlog = blogList[position]

        holder.blogItemTitle.text = currentBlog.title
        holder.blogItemAuthor.text = currentBlog.author
        holder.blogItemContent.text = currentBlog.content
    }

    override fun getItemCount(): Int {
        return blogList.size
    }
}
