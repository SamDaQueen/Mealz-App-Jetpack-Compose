package com.standex.mealzapp.presentation.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.standex.mealzapp.data.model.Meal
import com.standex.mealzapp.data.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Presentation Logic
class MealsCategoriesViewModel(private val model: MealsRepository = MealsRepository()) :
    ViewModel() {

    val mealsState: MutableState<List<Meal>> = mutableStateOf(emptyList())

    // For custom scope
    // private val mealsJob = Job()

    init {

        // Custom scope
        // val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        // scope.launch {
        //    mealsState.value = getMeals()
        // }
        // Using inbuilt viewModelScope
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }


    private suspend fun getMeals(): List<Meal> {
        return model.getMeals().categories
    }

    // For custom scope
    // override fun onCleared() {
    // super.onCleared()
    // mealsJob.cancel()
    // }
}