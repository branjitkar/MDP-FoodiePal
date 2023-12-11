package com.miu.foodieapp.model

import java.io.Serializable

data class Blog (
    val title: String?,
    val author: String?,
    val content: String?
) : Serializable