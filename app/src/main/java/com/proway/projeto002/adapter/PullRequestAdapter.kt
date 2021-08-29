package com.proway.projeto002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.proway.projeto002.R
import com.proway.projeto002.databinding.PullRequestItemLayoutBinding
import com.proway.projeto002.model.PullRequests

class PullRequestAdapter(val onItemClick: (PullRequests) -> Unit ): RecyclerView.Adapter<PullRequestViewHolder>() {

    private val pullRequestList = mutableListOf<PullRequests>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pull_request_item_layout, parent, false)
        return PullRequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        pullRequestList[position].apply {
            holder.bind(this)
            onItemClick(pullRequestList[position])
        }
    }

    override fun getItemCount(): Int = pullRequestList.size

    fun refresh(newList: List<PullRequests>) {
        pullRequestList.clear()
        pullRequestList.addAll(newList)
        notifyDataSetChanged()
    }
}

class PullRequestViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = PullRequestItemLayoutBinding.bind(view)

    fun bind(pullRequests: PullRequests) {
        binding.titlePullRequestTextView.text = pullRequests.title
        binding.bodyPullRequestTextView.text = pullRequests.description
        binding.dateOfCreationTextView.text = pullRequests.dataOfCreation
        binding.colaboratorNameTextView.text = pullRequests.user.name

        val radius = itemView.context.resources.getDimensionPixelSize(R.dimen.corner_radius)
        pullRequests.user.apply {
            Glide.with(itemView.context)
                .load(this.avatar)
                .transform(RoundedCorners(radius))
                .into(binding.userAvatarImageView)
        }
    }
}