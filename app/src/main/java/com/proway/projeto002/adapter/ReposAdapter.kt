package com.proway.projeto002.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.proway.projeto002.R
import com.proway.projeto002.databinding.ItemReposBinding
import com.proway.projeto002.databinding.TagForkStarLayoutBinding
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

    fun refresh(newList: List<Repos>) {
        listOfRepos.clear()
        listOfRepos.addAll(newList)
        notifyDataSetChanged()
    }
}

class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemReposBinding = ItemReposBinding.bind(itemView)

    fun bind(repos : Repos) {
        binding.reposNameTextView.text = repos.name
        binding.reposDescriptionTextView.text = repos.description
        binding.tagContainer.forksCountTextView.text = repos.forks.toString()
        binding.tagContainer.starCountTextView.text = repos.stars.toString()
        binding.userNameTextView.text = repos.user.name

        val radius = itemView.resources.getDimensionPixelSize(R.dimen.corner_radius)
        repos.user.let {
            Glide.with(itemView.context)
                .load(it.avatar)
                .transform(RoundedCorners(radius))
                .into(binding.userAvatarImageView)
        }
    }
}