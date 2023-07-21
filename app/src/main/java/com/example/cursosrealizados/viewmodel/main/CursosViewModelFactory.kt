package com.example.cursosrealizados.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cursosrealizados.repository.CursosRepository

class CursosViewModelFactory constructor(private val repository: CursosRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CursosViewModel::class.java)) {
            CursosViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}