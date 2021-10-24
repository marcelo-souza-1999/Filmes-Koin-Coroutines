package com.marcelo.filmecoroutineskoin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.marcelo.filmecoroutineskoin.R
import com.marcelo.filmecoroutineskoin.repository.MainRepository
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: MainViewModel = ViewModelProvider(this, MainViewModel.ViewModelFactory(
            MainRepository())).get(MainViewModel::class.java)

        viewModel.moviesLiveData.observe(viewLifecycleOwner, { getMovies->
            txtMovies.text = getMovies[0].title
        })

        //viewModel.getMovies()

        viewModel.getMoviesCoroutines()
    }

}