package mx.fintonic.test.ui.domain.usecases

import dagger.Reusable
import kotlinx.coroutines.withContext
import mx.fintonic.test.domain.dispatchers.DispatcherProvider
import mx.fintonic.test.ui.data.repository.BeerRepository
import mx.fintonic.test.ui.domain.models.Beers
import javax.inject.Inject

@Reusable
class FindBeers @Inject constructor(
    private val repository: BeerRepository,
    private val dispatcherProvider: DispatcherProvider,
) {

    suspend operator fun invoke(page: Int = 0): Beers =
        withContext(dispatcherProvider.default) { repository.beers(page = page) }
}