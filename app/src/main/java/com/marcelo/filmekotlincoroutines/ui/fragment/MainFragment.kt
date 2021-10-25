package com.marcelo.filmekotlincoroutines.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marcelo.filmecoroutineskoin.R
import com.marcelo.filmekotlincoroutines.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : Fragment() {

    private val name: String = "Marcelo"

    private val viewModel: MainViewModel by viewModel {
        parametersOf(name)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.moviesLiveData.observe(viewLifecycleOwner, { getMovies->
           txtMovies.text = getMovies.map {data ->
                "${data.id} - ${data.title} "

            }.toString()
        })

        //viewModel.getMovies()

        viewModel.getMoviesCoroutines()
    }
}