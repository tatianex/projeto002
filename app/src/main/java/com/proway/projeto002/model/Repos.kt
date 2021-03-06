package com.proway.projeto002.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
    val user: User

) : Serializable

data class ReposResponse(
    @SerializedName("items")
    val items: List<Repos>
)