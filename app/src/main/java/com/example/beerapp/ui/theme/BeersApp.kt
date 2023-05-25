package com.example.beerapp.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.beerapp.R
import com.example.beerapp.ui.theme.screens.BeersViewModel
import com.example.beerapp.ui.theme.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeersApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            val beersViewModel: BeersViewModel = viewModel(
                factory = BeersViewModel.Factory
            )
            HomeScreen(beersUiState = beersViewModel.beersUiState)
        }
    }
}