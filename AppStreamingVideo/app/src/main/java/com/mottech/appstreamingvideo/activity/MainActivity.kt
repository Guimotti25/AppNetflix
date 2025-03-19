package com.mottech.appstreamingvideo.activity

import Filmes
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mottech.appstreamingvideo.R
import com.mottech.appstreamingvideo.adapter.FilmesAdapter
import com.mottech.appstreamingvideo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private var listaFilmes: List<Filmes> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicializa o ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Define o layout usando o binding
        window.statusBarColor = ContextCompat.getColor(this, R.color.cor_secundaria)

        configurarFilmes()
    }

    private fun configurarFilmes()
    {
        listaFilmes = listOf(
            Filmes(
                nomeFilme = "Harry Potter e a Pedra Filosofal",
                imagemFilme = R.drawable.imagem_capa_hp, // Substitua pelo ID da imagem no drawable
                descricaoFilme = "Harry Potter é um garoto órfão que descobre ser um bruxo ao completar 11 anos. Ele inicia sua jornada na Escola de Magia e Bruxaria de Hogwarts, onde faz amigos e enfrenta o temido Lord Voldemort.",
                linkFilme = "https://www.youtube.com/watch?v=VyHV0BRtdxo",
                anoFilme = "2001",
                elenco = listOf("Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Alan Rickman")
            ),
            Filmes(
                nomeFilme = "Star Trek",
                imagemFilme = R.drawable.imagem_capa_startrek, // Substitua pelo ID da imagem no drawable
                descricaoFilme = "A tripulação da nave estelar Enterprise parte em uma missão para explorar novos mundos e civilizações, enquanto enfrenta ameaças desconhecidas.",
                linkFilme = "https://www.youtube.com/watch?v=SyJszxnJydA",
                anoFilme = "2009",
                elenco = listOf("Chris Pine", "Zachary Quinto", "Zoe Saldana", "Karl Urban")
            ),
            Filmes(
                nomeFilme = "Titanic",
                imagemFilme = R.drawable.imagem_capa_titanic, // Substitua pelo ID da imagem no drawable
                descricaoFilme = "Jack e Rose se apaixonam durante a fatídica viagem inaugural do Titanic, o navio mais luxuoso já construído, que naufraga após colidir com um iceberg.",
                linkFilme = "https://www.youtube.com/watch?v=2e-eXJ6HgkQ",
                anoFilme = "1997",
                elenco = listOf("Leonardo DiCaprio", "Kate Winslet", "Billy Zane", "Kathy Bates")
            ),
            Filmes(
                nomeFilme = "Velozes e Furiosos",
                imagemFilme = R.drawable.imagem_capa_velozesfuriosos, // Substitua pelo ID da imagem no drawable
                descricaoFilme = "Dominic Toretto é um corredor de rua que vive sua vida um quarto de milha de cada vez. Ele se envolve em uma trama de roubo de equipamentos eletrônicos e é perseguido pela polícia.",
                linkFilme = "https://www.youtube.com/watch?v=ZsJz2TJAPjw",
                anoFilme = "2001",
                elenco = listOf("Vin Diesel", "Paul Walker", "Michelle Rodriguez", "Jordana Brewster")
            )
        )

        configurarAdapter()
    }

    private fun configurarAdapter()
    {
        // Configura o RecyclerView
        val adapter = FilmesAdapter(listaFilmes) { filme ->
            // Callback para clique no item
            val intent = Intent(this, DetalhesFilmeActivity::class.java)
            intent.putExtra("FILME", filme)
            startActivity(intent)
        }

        binding.recyclerFilmes.adapter = adapter
        binding.recyclerFilmes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)    }
}