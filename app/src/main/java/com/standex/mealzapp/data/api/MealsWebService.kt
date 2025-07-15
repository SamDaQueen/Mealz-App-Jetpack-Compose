package com.standex.mealzapp.data.api

import com.standex.mealzapp.data.model.MealsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private var apiService: MealsApiService

    init {
        val retrofit =
            Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiService = retrofit.create(MealsApiService::class.java)
    }

    suspend fun getMeals(): MealsCategoriesResponse {
        return apiService.getMeals()
    }
}