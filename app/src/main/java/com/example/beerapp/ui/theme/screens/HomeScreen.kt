package com.example.beerapp.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beerapp.R
import com.example.beerapp.ui.theme.BeerAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.beerapp.model.Beers


@Composable
fun HomeScreen(
    beersUiState: BeersUiState,
    modifier: Modifier = Modifier
) {
    when (beersUiState) {
        is BeersUiState.Loading -> LoadingScreen()
        is BeersUiState.Success -> BeersList(beersUiState.data)
        is BeersUiState.Error -> ErrorScreen()
    }
}



@Composable
fun BeersList(
    beers: List<Beers>,
    modifier: Modifier = Modifier
) {
    LazyColumn(content = {
        items(beers.size) { index ->
            BeerCard(beers = beers[index])
        }
    })
}
@Composable
fun BeerCard(
    beers: Beers,
    modifier: Modifier = Modifier
) {
    Title(beers = beers)
    BeerImage(beers = beers)
    Description(beers = beers)
}

@Composable
fun Title(
    beers: Beers,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = beers.name
        )
    }
}

@Composable
fun BeerImage(
    beers: Beers,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(beers.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = beers.name,
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)
        )
    }
}

@Composable
fun Description(
    beers: Beers,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = beers.description
        )
    }
}


/**
 * Loading and Error Screens
 */

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = null
        )
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    BeerAppTheme {
        LoadingScreen()
    }
}