package com.standex.mealzapp.data.repository

import com.google.gson.annotations.SerializedName
import com.standex.mealzapp.data.repository.MealsCategoriesResponse

class MealsRepository {

}

// should be the same name as the json key in the response
data class MealsCategoriesResponse(val categories: List<Meal>)

data class Meal(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)