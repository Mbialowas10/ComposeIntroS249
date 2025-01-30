package com.mbialowas.composeintros249.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.mbialowas.composeintros249.data.Movie
import com.mbialowas.composeintros249.data.moviesList

class MoviesViewModel: ViewModel() {
    private val _movies = mutableStateListOf<Movie>().apply{
        addAll(moviesList)
    }
    val movies: List<Movie> = _movies

    fun toggleFavorite(movieId: Int, isFavorite: Boolean) {
        val movieIndex = movies.indexOfFirst { it.id == movieId }
        if (movieIndex != -1) {
            _movies[movieIndex] = _movies[movieIndex].copy(isFavorite = isFavorite)
        }

    }


}