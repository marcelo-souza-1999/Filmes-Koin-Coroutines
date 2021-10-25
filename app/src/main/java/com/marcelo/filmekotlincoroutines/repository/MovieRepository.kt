package com.marcelo.filmekotlincoroutines.repository

import com.marcelo.filmecoroutineskoin.models.Movies

interface MovieRepository {
   suspend fun getMoviesCoroutines(): List<Movies>
}