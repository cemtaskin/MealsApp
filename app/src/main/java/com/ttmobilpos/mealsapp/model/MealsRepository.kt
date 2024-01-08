package com.ttmobilpos.mealsapp.model

import com.ttmobilpos.mealsapp.model.api.MealsWebService
import com.ttmobilpos.mealsapp.model.response.MealsCategoriesResponse

class MealsRepository (private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals() : MealsCategoriesResponse{
        return  webService.getMeals()
    }
}