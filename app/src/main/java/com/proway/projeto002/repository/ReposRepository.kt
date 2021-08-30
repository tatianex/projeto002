package com.proway.projeto002.repository

import com.proway.projeto002.model.ReposResponse
import com.proway.projeto002.endpoint.RetrofitBuilder
import com.proway.projeto002.model.PullRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposRepository() {

    private val service = RetrofitBuilder.getRepoService()

    fun fetchAllRepositories(onComplete: (ReposResponse?, String?) -> Unit) {

        val call = service.getAllRepo()
        call.enqueue(object : Callback<ReposResponse> {
            override fun onResponse(call: Call<ReposResponse>, response: Response<ReposResponse>) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                }
                else {
                    onComplete(null, "Nenhum repositório encontrado")
                }
            }

            override fun onFailure(call: Call<ReposResponse>, t: Throwable) {
                onComplete(null, t.message)
            }

        })
    }

    fun fetchAllPullRequests(owner: String, repo: String, onClomplete: (List<PullRequests>?, String?) -> Unit){

        val call = service.getPullRequest(owner, repo)
        call.enqueue(object : Callback<List<PullRequests>> {
            override fun onResponse( call: Call<List<PullRequests>>, response: Response<List<PullRequests>>) {
                if (response.body() != null) {
                    onClomplete(response.body(), null)
                }
                else {
                    onClomplete(null, "Nenhum pull request encontrado!")
                }
            }

            override fun onFailure(call: Call<List<PullRequests>>, t: Throwable) {
                onClomplete(null, t.message)
            }
        })
    }

}