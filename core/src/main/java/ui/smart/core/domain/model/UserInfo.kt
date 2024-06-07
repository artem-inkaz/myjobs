package ui.smart.core.domain.model

import ui.smart.core.domain.model.ActivityLevel
import ui.smart.core.domain.model.Gender
import ui.smart.core.domain.model.GoalType

data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)
