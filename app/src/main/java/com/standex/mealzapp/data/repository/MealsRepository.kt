package com.standex.mealzapp.data.repository

import com.standex.mealzapp.data.api.MealsWebService
import com.standex.mealzapp.data.model.MealsCategoriesResponse

// Data Logic
class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}