package mx.fintonic.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import mx.fintonic.test.ui.domain.usecases.FindBeers
import mx.fintonic.test.ui.domain.usecases.FindRandomBeers
import mx.fintonic.test.ui.presentation.BeerViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FindBeersUseCaseTest {

    private val findBeersService = mock<FindBeers>()
    private val findRandomBeersService = mock<FindRandomBeers>()
    private lateinit var viewModel: BeerViewModel

    @Before
    fun setup() {
        viewModel = BeerViewModel(findBeersService, findRandomBeersService)
    }

    @Test
    fun `Loading state works`() = runBlocking {
        whenever(findBeersService.invoke(1).bears).thenReturn(emptyList())
        viewModel = BeerViewModel(findBeersService, findRandomBeersService)
        Assert.assertEquals(BeerViewModel.State.Loading, viewModel.state.value)
    }

}