package com.proway.projeto002.repository

import com.proway.projeto002.model.ReposResponse
import com.proway.projeto002.endpoint.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposRepository() {

    val service = RetrofitBuilder.GetRepoService()

    fun fetchAll(onComplete: (ReposResponse?, String?) -> Unit) {

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

}