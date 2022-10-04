package mx.fintonic.test.ui.data.repository

import mx.fintonic.test.ui.data.mappers.BeerMapper
import mx.fintonic.test.ui.data.remote.BeerRemoteDataSource
import mx.fintonic.test.ui.domain.models.Beers
import javax.inject.Inject

class BeerRepository @Inject constructor(
    private val beerMapper: BeerMapper,
    private val remoteDataSource: BeerRemoteDataSource,
) {

    suspend fun beers(page:Int): Beers = Beers(beerMapper.map(remoteDataSource.beers(page)))
    suspend fun randomBeers(): Beers = Beers(beerMapper.map(remoteDataSource.randomBeers()))
}
