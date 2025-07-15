package com.standex.mealzapp.domain.model

import com.standex.mealzapp.data.api.MealsWebService
import com.standex.mealzapp.data.repository.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Data Logic
class MealsModel(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallBack: (response: MealsCategoriesResponse?) -> Unit) {

        // Without coroutines - bad practice
        // return webService.getMeals().execute().body()
        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
            override fun onResponse(
                call: Call<MealsCategoriesResponse?>,
                response: Response<MealsCategoriesResponse?>
            ) {
                if (response.isSuccessful)
                    successCallBack(response.body())
            }

            override fun onFailure(
                call: Call<MealsCategoriesResponse?>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }
        })
    }
}

