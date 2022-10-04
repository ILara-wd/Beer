package mx.fintonic.test.ui.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mx.fintonic.test.ui.domain.models.Beers
import mx.fintonic.test.ui.domain.usecases.FindBeers
import mx.fintonic.test.ui.domain.usecases.FindRandomBeers
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    private val findBeers: FindBeers,
    private val findRandomBeers: FindRandomBeers
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> get() = _state

    fun loadBeers(page: Int) {
        viewModelScope.launch {
            _state.value = State.Loading
            runCatching {
                findBeers(page)
            }
                .onSuccess { beers ->
                    _state.value = State.Success(beers)
                }
                .onFailure { throwable ->
                    Log.e("", throwable.message.toString())
                    _state.value = State.Retry
                }
        }
    }

    fun loadRandomBeers() {
        viewModelScope.launch {
            _state.value = State.Loading
            runCatching {
                findRandomBeers()
            }
                .onSuccess { beers ->
                    _state.value = State.Success(beers)
                }
                .onFailure { throwable ->
                    Log.e("", throwable.message.toString())
                    _state.value = State.Retry
                }
        }
    }

    sealed class State {
        object Loading : State()
        object Retry : State()
        data class Success(val response: Beers) : State()
    }

}