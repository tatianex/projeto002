package com.proway.projeto002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto002.R
import com.proway.projeto002.model.Repos

class ReposAdapter(val onItemClick: (Repos) -> Unit) : RecyclerView.Adapter<ReposViewHolder>() {

    private val listOfRepos: MutableList<Repos> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repos, parent, false)
        return ReposViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        listOfRepos[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener { onItemClick(this) }
        }
    }

    override fun getItemCount(): Int = listOfRepos.size
}

class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(repos : Repos) {
        setData(repos.name, R.id.reposNameTextView)
        setData(repos.description, R.id.reposDescriptionTextView)
    }

    private fun setData(value: String?, @IdRes componentId: Int) {
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }
}