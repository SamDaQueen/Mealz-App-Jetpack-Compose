package com.standex.mealzapp.data.repository

import com.standex.mealzapp.data.api.MealsWebService
import com.standex.mealzapp.data.model.MealsCategoriesResponse
import com.standex.mealzapp.domain.repository.MealsRepository

// Data Logic
class MealsRepositoryImpl(private val apiService: MealsWebService = MealsWebService()) :
    MealsRepository {
    override suspend fun getMeals(): MealsCategoriesResponse {
        return apiService.getMeals()
    }
}