package com.proway.projeto002.view

import android.content.Intent
import android.net.Uri
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
import com.proway.projeto002.model.Repos
import com.proway.projeto002.view_model.PullRequestViewModel

class PullRequestFragment : Fragment(R.layout.pull_request_fragment) {

    companion object {
        fun newInstance(name: String, repo: String) : PullRequestFragment {
            return PullRequestFragment().apply {

                arguments = Bundle().apply {
                    putString("name", name)
                    putString("repo", repo)
                }
            }
        }
    }

    private lateinit var viewModel: PullRequestViewModel
    private lateinit var binding: PullRequestFragmentBinding
    private val adapter = PullRequestAdapter{
        val browser = Intent(Intent.ACTION_VIEW, Uri.parse(it.htmlUrl))
        startActivity(browser)
    }

    private val observerPullRequest = Observer<List<PullRequests>> {
        adapter.refresh(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = PullRequestFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)

        val repo = arguments?.getSerializable("repo") as? Repos?

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


        if (repo != null) {
            viewModel.fetchAll(repo.user.name, repo.name)
        }

    }
}