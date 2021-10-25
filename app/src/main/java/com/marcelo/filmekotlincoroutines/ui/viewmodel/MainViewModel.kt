package com.marcelo.filmekotlincoroutines.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcelo.filmecoroutineskoin.models.Movies
import com.marcelo.filmekotlincoroutines.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepository,
    private val texto: String,
) : ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movies>>()

    /*fun getMovies() {
        repository.getMovies { movies ->
            moviesLiveData.postValue(movies)
        }
    }*/


    fun getMoviesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesLiveData.value = movies

            Log.d("testeParametro", "Nome que veio por parametro do modulo é: "+texto)
        }
    }
}