package com.proway.projeto002.model

data class Repos(

    val id: Int,
    val name: String,
    val description: String,
    val forks_count: Int,
    val stargazers_count: Int,
    val owner: Owner

)