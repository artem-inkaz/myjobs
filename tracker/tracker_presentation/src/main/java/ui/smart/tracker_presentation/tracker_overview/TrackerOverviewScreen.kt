package ui.smart.tracker_presentation.tracker_overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import ui.smart.core_ui.LocalSpacing
import ui.smart.tracker_presentation.tracker_overview.components.AddButton
import ui.smart.tracker_presentation.tracker_overview.components.DaySelector
import ui.smart.tracker_presentation.tracker_overview.components.ExpandableMeal
import ui.smart.tracker_presentation.tracker_overview.components.NutrientsHeader
import ui.smart.tracker_presentation.tracker_overview.components.TrackedFoodItem

@ExperimentalCoilApi
@Composable
fun TrackerOverviewScreen(
    onNavigateToSearch: (String,String, Int, Int, Int) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceLarge)
    ) {
        item {
            NutrientsHeader(state = state)
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            DaySelector(
                date = state.date,
                onPreviousDayClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick)
                },
                onNextDayClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
        items(state.meals) { meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(meal))
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                            .padding(bottom = spacing.spaceLarge)
                    ) {
                        state.trackedFoods.filter { it.mealType == meal.mealType}.forEach { food ->
                            TrackedFoodItem(
                                trackedFood = food,
                                onDeleteClick = {
                                    viewModel.onEvent(
                                        TrackerOverviewEvent
                                            .OnDeleteTrackedFoodClick(food)
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        }
                        AddButton(
                            text = stringResource(
                                id = ui.smart.core.R.string.add_meal,
                                meal.name.asString(context)
                            ),
                            onClick = {
                                onNavigateToSearch(
                                    meal.name.asString(context),
                                    meal.mealType.name,
                                    state.date.dayOfMonth,
                                    state.date.monthValue,
                                    state.date.year
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}