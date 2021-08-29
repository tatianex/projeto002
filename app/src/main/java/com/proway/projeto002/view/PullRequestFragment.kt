package com.proway.projeto002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proway.projeto002.R
import com.proway.projeto002.adapter.PullRequestAdapter
import com.proway.projeto002.databinding.PullRequestFragmentBinding
import com.proway.projeto002.view_model.PullRequestViewModel

class PullRequestFragment : Fragment(R.layout.pull_request_fragment) {

    companion object {
        fun newInstance() = PullRequestFragment()
    }

    private lateinit var viewModel: PullRequestViewModel
    private lateinit var binding: PullRequestFragmentBinding
    private val adapter = PullRequestAdapter {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}