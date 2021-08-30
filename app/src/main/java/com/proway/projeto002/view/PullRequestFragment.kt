package com.proway.projeto002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.projeto002.R
import com.proway.projeto002.adapter.PullRequestAdapter
import com.proway.projeto002.databinding.PullRequestFragmentBinding
import com.proway.projeto002.model.PullRequests
import com.proway.projeto002.view_model.PullRequestViewModel

class PullRequestFragment : Fragment(R.layout.pull_request_fragment) {

    companion object {
        fun newInstance() = PullRequestFragment()
    }

    private lateinit var viewModel: PullRequestViewModel
    private lateinit var binding: PullRequestFragmentBinding
    private val adapter = PullRequestAdapter() {
        viewModel.fetchAll(it.user.name, it.title)
    }

    private val observerPullRequest = Observer<List<PullRequests>> {
        adapter.refresh(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = PullRequestFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)

        binding.pullRequestRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.pullRequestRecyclerView.adapter = adapter

        viewModel.pullRequest.observe(viewLifecycleOwner, observerPullRequest)

        binding.backButton.apply {
            setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, RepoListFragment.newInstance())
                    .commitNow()
            }
        }
    }
}