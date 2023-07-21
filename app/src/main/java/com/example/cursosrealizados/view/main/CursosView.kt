package com.example.cursosrealizados.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cursosrealizados.adapter.CursosAdapter
import com.example.cursosrealizados.databinding.ActivityMainBinding
import com.example.cursosrealizados.model.CursosModel
import com.example.cursosrealizados.repository.CursosRepository
import com.example.cursosrealizados.retrofit.RetrofitService
import com.example.cursosrealizados.viewmodel.main.CursosViewModel
import com.example.cursosrealizados.view.novo_curso.NovoCursoActivity
import com.example.cursosrealizados.viewmodel.main.CursosViewModelFactory

class CursosView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CursosViewModel
    private val retrofitService = RetrofitService.getInstance()

    private val adapter = CursosAdapter { cursos ->
        openCursos(cursos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, CursosViewModelFactory(CursosRepository(retrofitService))).get(
            CursosViewModel::class.java
        )

        setupUI()
    }

    override fun onResume() {
        super.onResume()

       viewModel.getAllCursos()
    }

    override fun onStart() {
        super.onStart()
        viewModel.cursosList.observe(this, Observer { cursos ->
            updateCursosList(cursos)
        })
    }

    fun setupUI(){

        binding.fabMain.setOnClickListener{
            startActivity(Intent(this, NovoCursoActivity::class.java))
        }
        binding.reciclerMain.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.reciclerMain.layoutManager = LinearLayoutManager(this)
        binding.reciclerMain.adapter = adapter
    }

    private fun updateCursosList(cursos: List<CursosModel>) {
        adapter.setCursosList(cursos)
    }

    private fun openCursos(cursos: CursosModel) {
    }

}