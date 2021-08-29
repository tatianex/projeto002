package com.proway.projeto002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.projeto002.R
import com.proway.projeto002.adapter.ReposAdapter
import com.proway.projeto002.databinding.RepoListFragmentBinding
import com.proway.projeto002.model.Repos
import com.proway.projeto002.view_model.MainViewModel

class RepoListFragment : Fragment(R.layout.repo_list_fragment) {

    companion object {
        fun newInstance() = RepoListFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: RepoListFragmentBinding
    private val adapter = ReposAdapter{ repo ->
        val bundle = Bundle()
        bundle.putSerializable("repo", repo)
    }

    private val observerRepos = Observer<List<Repos>> {
        adapter.refresh(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RepoListFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.reposRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecyclerView.adapter = adapter

        viewModel.repo.observe(viewLifecycleOwner, observerRepos)
        viewModel.getAllRepo()
    }
}