package com.standex.mealzapp.domain.model

import com.standex.mealzapp.data.api.MealsWebService
import com.standex.mealzapp.data.repository.MealsCategoriesResponse

// Data Logic
class MealsModel(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(): MealsCategoriesResponse? {

        // Without coroutines - bad practice
        return webService.getMeals().execute().body()
    }
}

