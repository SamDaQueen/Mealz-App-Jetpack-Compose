package com.standex.mealzapp.domain.repository

import com.standex.mealzapp.data.model.MealsCategoriesResponse

interface MealsRepository {
    suspend fun getMeals(): MealsCategoriesResponse
}