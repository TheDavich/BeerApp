# 🍻 Beers App

## 📖 Overview

The Beers App is designed to showcase a list of beers along with their images and descriptions. It uses Kotlin, follows the MVVM architecture, and leverages Dependency Injection (DI) for efficient data management. Retrofit is used for making API requests to fetch beer data.

## 🌐 Retrofit API Integration

The app integrates with an external API to retrieve beer data. The API endpoint used is as follows:

https://api.punkapi.com/v2/beers

## 🧱 MVVM Architecture

The app follows the Model-View-ViewModel (MVVM) architecture:

### `BeersUiState`

```kotlin
sealed interface BeersUiState {
    object Loading : BeersUiState
    data class Success(val data: List<Beers>) : BeersUiState
    object Error : BeersUiState
}
```
The BeersUiState interface represents different UI states, including loading, success, and error.

### `BeersViewModel`

```kotlin
class BeersViewModel(private val beersRepository: BeersRepository): ViewModel() {
    // ViewModel code...
}
```
The BeersViewModel class manages UI data and communicates with the repository to fetch beer data.

UI Components
The user interface is built using Jetpack Compose and includes components like HomeScreen, BeersList, BeerCard, Title, BeerImage, and Description.

## Dependency Injection (DI) 💉
The app uses Dependency Injection (DI) for managing dependencies:

### `AppContainer`
```kotlin
interface AppContainer {
    val beersRepository: BeersRepository
}
```
The AppContainer interface defines a container for managing dependencies, including the BeersRepository.

### `DefaultAppContainer`
```kotlin
class DefaultAppContainer: AppContainer {
    // Dependency setup code...
}
```
The DefaultAppContainer class provides the implementation for the AppContainer interface, including the repository and Retrofit setup.

## Retrofit for API Calls 🌐
The app uses Retrofit to make API calls:

### `BeersApiService`
```kotlin
interface BeersApiService {
    @GET("beers")
    suspend fun getBeers(): List<Beers>
}
```
The BeersApiService interface defines the API endpoint for fetching beer data.
## Data Classes

The project includes data classes like Beers to represent beer data.

## 🚀 Getting Started
To run the app locally, follow these steps:

1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or device.

## 📷 Screenshots
<img width="371" alt="Beerapp" src="https://github.com/TheDavich/BeerApp/assets/87846576/ddc1dd36-2743-4c46-be7d-206c036e911e">

