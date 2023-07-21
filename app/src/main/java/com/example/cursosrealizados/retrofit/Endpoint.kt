package com.example.cursosrealizados.retrofit


import com.example.cursosrealizados.model.CursosModel
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("api/curso/v1")
    fun getCursos() : Call<List<CursosModel>>

}