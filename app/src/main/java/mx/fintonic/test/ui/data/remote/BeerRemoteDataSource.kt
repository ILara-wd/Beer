package mx.fintonic.test.ui.data.remote

import mx.fintonic.test.data.remote.services.ApiServices
import mx.fintonic.test.ui.data.remote.models.BeersResponse
import javax.inject.Inject

class BeerRemoteDataSource @Inject constructor(
    private val apiServices: ApiServices,
) {

    suspend fun beers(page: Int): List<BeersResponse> = apiServices.serviceReadBeer(page)
    suspend fun randomBeers(): List<BeersResponse> = apiServices.serviceReadBeerRandom()
}
