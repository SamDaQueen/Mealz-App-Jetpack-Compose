package com.standex.mealzapp.presentation.ui.meals

import androidx.lifecycle.ViewModel
import com.standex.mealzapp.data.repository.MealsCategoriesResponse
import com.standex.mealzapp.domain.model.MealsModel

// Presentation Logic
class MealsCategoriesViewModel (private val model: MealsModel = MealsModel()): ViewModel() {

    fun getMeals(successCallBack: (response: MealsCategoriesResponse?) -> Unit) {
        return model.getMeals() { response ->
            successCallBack(response)
        }
    }
}