package com.proway.projeto002.model

import com.google.gson.annotations.SerializedName

data class ReposResponse(val items: List<Repos>)

data class Repos(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("forks_count")
    val forks: Int,

    @SerializedName("stargazers_count")
    val stars: Int,

    @SerializedName("owner")
    val owner: Owner

)