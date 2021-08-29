package com.proway.projeto002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto002.model.Repos
import com.proway.projeto002.repository.ReposRepository

class MainViewModel : ViewModel() {

    private val repository = ReposRepository()

    private val _repo = MutableLiveData<List<Repos>>()
    val repo: LiveData<List<Repos>> = _repo

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getAllRepo() {
        repository.fetchAll() { response, error ->
            response?.let {
                _repo.value = it.items
            }
            error?.let{
                _error.value = it
            }
        }
    }

}