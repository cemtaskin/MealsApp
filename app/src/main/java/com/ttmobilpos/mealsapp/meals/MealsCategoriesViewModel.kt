package com.ttmobilpos.mealsapp.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttmobilpos.mealsapp.model.MealsRepository
import com.ttmobilpos.mealsapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()): ViewModel() {
    val mealsState : MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value=meals
        }
    }

    private suspend fun getMeals ():List<MealResponse>{
        return repository.getMeals().categories
    }
}