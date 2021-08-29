package com.proway.projeto002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto002.model.PullRequests
import com.proway.projeto002.repository.ReposRepository

class PullRequestViewModel : ViewModel() {

    val repository = ReposRepository()

    val _pullRequest = MutableLiveData<List<PullRequests>>()
    val pullRequest : LiveData<List<PullRequests>> = _pullRequest

    val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchAll(url: String) {
        repository.fetchAll(url) { response, error ->
            response?.apply {
                _pullRequest.value = this
            }
            error?.let {
                _error.value = it
            }
        }
    }
}