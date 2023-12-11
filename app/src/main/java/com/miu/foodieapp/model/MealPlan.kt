package com.miu.foodieapp.model

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

data class MealPlan(
    val breakfast: String?,
    val lunch: String?,
    val dinner: String?,
    val mealDateTime: LocalDate
): Serializable