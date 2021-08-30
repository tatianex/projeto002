package com.proway.projeto002.endpoint

import com.proway.projeto002.model.PullRequests
import com.proway.projeto002.model.ReposResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface RepoService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getAllRepo(): Call<ReposResponse>

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPullRequest(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<List<PullRequests>>
}