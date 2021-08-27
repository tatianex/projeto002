package com.proway.projeto002.model

import androidx.room.Entity

@Entity
data class Owner(

    val name: String,
    val avatar_url: String
)
