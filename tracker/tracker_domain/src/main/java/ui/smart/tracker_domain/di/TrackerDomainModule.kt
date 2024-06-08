package ui.smart.tracker_domain.di

import ui.smart.tracker_domain.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ui.smart.core.domain.preferences.Preferences
import ui.smart.tracker_domain.use_case.CalculateMealNutrients
import ui.smart.tracker_domain.use_case.DeleteTrackedFood
import ui.smart.tracker_domain.use_case.GetFoodsForDate
import ui.smart.tracker_domain.use_case.SearchFood
import ui.smart.tracker_domain.use_case.TrackFood
import ui.smart.tracker_domain.use_case.TrackerUseCases

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}