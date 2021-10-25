package com.marcelo.filmekotlincoroutines.repository

import com.marcelo.filmecoroutineskoin.models.Movies
import kotlinx.coroutines.*

class MainRepository : MovieRepository{

   /* fun getMovies(callback: (movies: List<Movies>) -> Unit){
        Thread{
            Thread.sleep(3000)
            callback(
                listOf(
                    Movies(1, "Filme um"),
                    Movies(2, "Filme dois")
                )
            )
        }.start()
    }*/

     override suspend fun getMoviesCoroutines(): List<Movies> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Movies(1, "Filme um"),
                Movies(2, "Filme dois")
            )
        }
    }
}