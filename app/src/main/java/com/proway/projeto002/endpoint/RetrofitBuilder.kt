package com.proway.projeto002.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val repoRetrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun GetRepoService() : RepoService {
        return repoRetrofit.create(RepoService::class.java)
    }
}