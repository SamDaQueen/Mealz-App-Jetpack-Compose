package com.standex.mealzapp.data.api

import com.standex.mealzapp.data.repository.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {

    private var apiService: MealsApiService

    init {
        val retrofit =
            Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiService = retrofit.create(MealsApiService::class.java)
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        return apiService.getMeals()
    }

    interface MealsApiService {
        @GET("categories.php")
        fun getMeals(): Call<MealsCategoriesResponse>
    }
}