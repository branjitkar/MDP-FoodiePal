package com.miu.foodieapp.model

import java.io.FileDescriptor
import java.io.Serializable

data class Recipe(
    val name: String,
    val description: String,
    val ingredients: String,
    val instructions: String,
    val image: Int,
    val cookingTime: String
) : Serializable