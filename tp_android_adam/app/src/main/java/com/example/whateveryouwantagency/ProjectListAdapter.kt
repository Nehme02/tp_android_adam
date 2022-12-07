package com.example.whateveryouwantagency

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectListAdapter(private val listener: NewsItemClicked) : RecyclerView.Adapter<ProjectViewHolder>() {
    private val items: ArrayList<Projects> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = ProjectViewHolder(view)
        view.setOnClickListener{
            listener.onItemCliked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(NewsViewHolder, Int){
        val currentItem = items[position]
        holder.titleView.text=currentItem.title
        holder.description.text = currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.imageURL).into(holder.image)
    }
    fun updateProjects(updatedProjects : ArrayList<Projects>) {
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}
class ProjectViewHolder(View) :RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.description)
    val date: TextView = itemView.findViewById(R.id.date)
}