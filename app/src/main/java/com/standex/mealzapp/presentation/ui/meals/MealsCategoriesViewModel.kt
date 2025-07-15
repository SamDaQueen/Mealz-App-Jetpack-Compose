package com.standex.mealzapp.presentation.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.standex.mealzapp.data.model.Meal
import com.standex.mealzapp.data.repository.MealsRepositoryImpl
import com.standex.mealzapp.domain.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Presentation Logic
class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepositoryImpl()) :
    ViewModel() {

    val mealsState: MutableState<List<Meal>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<Meal> {
        return repository.getMeals().categories
    }
}