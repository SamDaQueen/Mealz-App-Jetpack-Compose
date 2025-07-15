package com.standex.mealzapp.data.api

import com.standex.mealzapp.data.model.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApiService {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}