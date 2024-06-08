package ui.smart.tracker_domain.use_case

import ui.smart.tracker_domain.model.TrackedFood
import ui.smart.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}