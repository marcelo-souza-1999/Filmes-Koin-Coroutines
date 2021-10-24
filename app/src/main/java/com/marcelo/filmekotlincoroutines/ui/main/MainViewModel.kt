package com.marcelo.filmecoroutineskoin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcelo.filmecoroutineskoin.models.Movies
import com.marcelo.filmecoroutineskoin.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movies>>()

    /*fun getMovies() {
        repository.getMovies { movies ->
            moviesLiveData.postValue(movies)
        }
    }*/


    fun getMoviesCoroutines () {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesLiveData.value = movies
        }
    }

    class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return  MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Classe ViewModel desconhecida")
        }

    }
}