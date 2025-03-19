package com.mottech.appstreamingvideo.adapter

import Filmes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mottech.appstreamingvideo.R

class FilmesAdapter(
    private val listaFilmes: List<Filmes>, // Lista de filmes
    private val onItemClick: (Filmes) -> Unit // Callback para clique no item
) : RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {

    // ViewHolder para o adapter
    inner class FilmesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewPoster: AppCompatImageView = itemView.findViewById(R.id.imagemFilmes)

        // Vincula os dados do filme às views
        fun bind(filme: Filmes) {
            imageViewPoster.setImageResource(filme.imagemFilme)
            // Configura o clique no item
            itemView.setOnClickListener {
                onItemClick(filme)
            }
        }
    }

    // Cria o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_filme, parent, false)
        return FilmesViewHolder(view)
    }

    // Vincula os dados ao ViewHolder
    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        val filme = listaFilmes[position]
        holder.bind(filme)
    }

    // Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return listaFilmes.size
    }
}