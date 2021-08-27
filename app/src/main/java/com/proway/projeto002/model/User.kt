package com.proway.projeto002.model

import androidx.room.Entity

@Entity
data class User(

    val name: String,
    val avatar_url: String
)
