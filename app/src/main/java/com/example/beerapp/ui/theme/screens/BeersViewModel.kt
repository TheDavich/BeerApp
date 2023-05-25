package com.example.beerapp.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.beerapp.BeersApplication
import com.example.beerapp.data.BeersRepository
import com.example.beerapp.model.Beers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface BeersUiState {
    object Loading : BeersUiState
    data class Success(val data: List<Beers>) : BeersUiState
    object  Error: BeersUiState
}

class BeersViewModel(private val beersRepository: BeersRepository): ViewModel() {

    var beersUiState: BeersUiState by mutableStateOf(BeersUiState.Loading)
        private set

    init {
        getBeers()
    }

    fun getBeers() {
        viewModelScope.launch {
            beersUiState = BeersUiState.Loading
            beersUiState = try {
                BeersUiState.Success(beersRepository.getBeers())
            } catch (e: IOException) {
                BeersUiState.Error
            } catch (e: HttpException) {
                BeersUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BeersApplication)
                val beersRepository = application.container.beersRepository
                BeersViewModel(beersRepository = beersRepository)
            }
        }
    }
}