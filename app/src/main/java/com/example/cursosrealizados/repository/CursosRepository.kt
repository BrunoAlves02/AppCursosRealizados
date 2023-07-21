package com.example.cursosrealizados.repository

import com.example.cursosrealizados.model.CursosModel
import com.example.cursosrealizados.retrofit.RetrofitService

class CursosRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCursos(): List<CursosModel> {
        val cursos = mutableListOf<CursosModel>()

        return cursos
    }

}