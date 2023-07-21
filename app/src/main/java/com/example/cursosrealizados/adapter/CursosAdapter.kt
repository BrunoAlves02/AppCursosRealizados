package com.example.cursosrealizados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursosrealizados.databinding.ItemCursoBinding
import com.example.cursosrealizados.model.CursosModel

class CursosAdapter(private val onItemClicked: (CursosModel) -> Unit) : RecyclerView.Adapter<CursosViewHolder>() {

    private var cursos = mutableListOf<CursosModel>()

    fun setCursosList(lives: List<CursosModel>) {

        this.cursos = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCursoBinding.inflate(inflater, parent, false)
        return CursosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val live = cursos[position]
        holder.bind(live, onItemClicked)
    }

    override fun getItemCount(): Int {
        return cursos.size
    }


}

class CursosViewHolder(val binding: ItemCursoBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(cursos: CursosModel, onItemClicked: (CursosModel) -> Unit) {

        binding.textNomeCurso.text = cursos.nome
        binding.textDescricao.text = cursos.descricao
        binding.textCargaHoraria.text = cursos.cargaHoraria

        itemView.setOnClickListener {
            onItemClicked(cursos)
        }

    }
}