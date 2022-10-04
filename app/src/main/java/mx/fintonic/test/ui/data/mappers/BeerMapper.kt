package mx.fintonic.test.ui.data.mappers

import mx.fintonic.test.domain.mapper.Mapper
import mx.fintonic.test.ui.data.remote.models.BeersResponse
import mx.fintonic.test.ui.presentation.models.BeerDataUI
import javax.inject.Inject

class BeerMapper @Inject constructor() : Mapper<BeersResponse, BeerDataUI> {

    override fun map(value: BeersResponse): BeerDataUI = with(value) {
        BeerDataUI(
            id = id,
            name = name,
            description = description,
            imageUrl = imageUrl
        )
    }
}
