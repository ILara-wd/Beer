package mx.fintonic.test.data.remote.services

import mx.fintonic.test.data.remote.services.ServiceNames.BEERS
import mx.fintonic.test.data.remote.services.ServiceNames.RANDOM
import mx.fintonic.test.ui.data.remote.models.BeersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(BEERS)
    suspend fun serviceReadBeer(@Query("page") page: Int): List<BeersResponse>

    @GET(RANDOM)
    suspend fun serviceReadBeerRandom(): List<BeersResponse>
}
