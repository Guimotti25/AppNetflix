package com.mottech.appstreamingvideo.activity

import Filmes
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mottech.appstreamingvideo.R
import com.mottech.appstreamingvideo.databinding.ActivityDetalhesFilmeBinding

class DetalhesFilmeActivity : AppCompatActivity()
{
    // Declaração do binding
    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicializa o ViewBinding
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root) // Define o layout usando o binding
        window.statusBarColor = ContextCompat.getColor(this, R.color.cor_secundaria)

        // Agora você pode acessar as views diretamente pelo binding
        // Exemplo: binding.textViewTitulo.text = "Título do Filme"
        val filme = intent.getParcelableExtra<Filmes>("FILME")

        binding.imageCadastroUsuario.setImageResource(filme!!.imagemFilme)
        binding.textViewNome.text = filme.nomeFilme
        binding.textViewAno.text = filme.anoFilme
        binding.textViewDescricao.text = filme.descricaoFilme

        binding.iconeVoltar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}