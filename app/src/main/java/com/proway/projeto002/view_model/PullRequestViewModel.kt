package com.proway.projeto002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto002.model.PullRequests
import com.proway.projeto002.repository.ReposRepository

class PullRequestViewModel : ViewModel() {

    private val repository = ReposRepository()

    private val _pullRequest = MutableLiveData<List<PullRequests>>()
    val pullRequest : LiveData<List<PullRequests>> = _pullRequest

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchAll(owner: String, repo: String) {
        repository.fetchAll(owner, repo) { response, error ->
            response?.apply {
                _pullRequest.value = this
            }
            error?.let {
                _error.value = it
            }
        }
    }
}