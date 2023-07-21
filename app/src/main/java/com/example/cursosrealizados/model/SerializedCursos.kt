package com.example.cursosrealizados.model

import com.google.gson.annotations.SerializedName

data class SerializedCursos (
    @SerializedName("nome")
    var nome : String,
    @SerializedName("descricao")
    var descricao : String,
    @SerializedName("cargaHoraria")
    var cargaHoraria : String,
)