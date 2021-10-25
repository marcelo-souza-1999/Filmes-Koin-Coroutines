package com.marcelo.filmekotlincoroutines.directory

import com.marcelo.filmekotlincoroutines.repository.MainRepository
import com.marcelo.filmekotlincoroutines.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory {
        MainRepository()
    }

    viewModel {
       MainViewModel(
           repository = get(),
           texto = "Marcelo"
       )
    }
}