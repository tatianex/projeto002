package com.proway.projeto002.model

import com.google.gson.annotations.SerializedName

data class PullRequests(

    @SerializedName("title")
    val title: String,

    @SerializedName("created_at")
    val dataOfCreation: String,

    @SerializedName("body")
    val description: String,

    @SerializedName("user")
    val user: User
)
