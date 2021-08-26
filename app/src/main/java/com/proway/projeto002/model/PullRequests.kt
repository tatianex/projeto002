package com.proway.projeto002.model

data class PullRequests(

    val name: String,
    val created_at: String,
    val html_url: String,
    val user: User
)
