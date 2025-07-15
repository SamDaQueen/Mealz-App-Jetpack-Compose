package com.standex.mealzapp.presentation.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.standex.mealzapp.data.repository.Meal
import com.standex.mealzapp.presentation.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

// View Logic
@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    //    val meals =
    //        viewModel.getMeals() // Bad practice - will call each time the composable is recomposed

    val rememberedCategories: MutableState<List<Meal>> = remember { mutableStateOf(emptyList()) }
    viewModel.getMeals { response ->
        val mealsFromApi = response?.categories
        rememberedCategories.value = mealsFromApi.orEmpty()
    }
    LazyColumn {
        items(rememberedCategories.value) { categories ->
            Text(
                text = categories.name
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}