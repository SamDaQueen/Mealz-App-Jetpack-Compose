package com.standex.mealzapp.presentation.ui.meals

import androidx.lifecycle.ViewModel
import com.standex.mealzapp.data.repository.Meal
import com.standex.mealzapp.domain.model.MealsModel

// Presentation Logic
class MealsCategoriesViewModel (private val model: MealsModel = MealsModel()): ViewModel() {

    suspend fun getMeals(): List<Meal> {
        return model.getMeals().categories
    }
}