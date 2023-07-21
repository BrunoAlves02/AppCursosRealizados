package com.example.cursosrealizados.viewmodel.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cursosrealizados.model.CursosModel
import com.example.cursosrealizados.repository.CursosRepository
import com.example.cursosrealizados.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class CursosViewModel constructor(private val repository: CursosRepository) : ViewModel() {

    var cursosList = MutableLiveData<List<CursosModel>>()

/*    fun getAllCursos(){
        val cursos = this.repository.getAllCursos()

        android.os.Handler().postDelayed({
            cursosList.postValue(cursos as List<CursosModel>?)
        }, 5000)

    }

 */

    fun getAllCursos() {
        val cursos = this.repository.getAllCursos()
        val retrofitClient = RetrofitService.getInstance()
        val callback = retrofitClient.getCursos()



        callback.enqueue(object : Callback<List<CursosModel>> {
            override fun onResponse(
                call: Call<List<CursosModel>>,
                response: Response<List<CursosModel>>
            ) {
                if (response.isSuccessful){
                    cursosList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<CursosModel>>, t: Throwable) {
                println("Erro throw: ... " + t.message.toString())
            }

        })

    }

}