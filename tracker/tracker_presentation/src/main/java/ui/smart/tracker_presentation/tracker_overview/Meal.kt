package ui.smart.tracker_presentation.tracker_overview

import androidx.annotation.DrawableRes
import ui.smart.core.util.UiText
import ui.smart.tracker_domain.model.MealType

data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)

val defaultMeals = listOf(
    Meal(
        name = UiText.StringResource(ui.smart.core.R.string.breakfast),
        drawableRes = ui.smart.core.R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UiText.StringResource(ui.smart.core.R.string.lunch),
        drawableRes = ui.smart.core.R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResource(ui.smart.core.R.string.dinner),
        drawableRes = ui.smart.core.R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.StringResource(ui.smart.core.R.string.snacks),
        drawableRes = ui.smart.core.R.drawable.ic_snack,
        mealType = MealType.Snack
    ),
)
