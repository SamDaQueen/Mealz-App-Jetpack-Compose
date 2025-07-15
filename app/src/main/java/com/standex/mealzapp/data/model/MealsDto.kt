package com.standex.mealzapp.data.model

import com.google.gson.annotations.SerializedName

// should be the same name as the json key in the response
data class MealsCategoriesResponse(val categories: List<Meal>)

data class Meal(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)