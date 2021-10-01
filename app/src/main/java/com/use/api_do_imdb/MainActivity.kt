package com.use.api_do_imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.use.api_do_imdb.api.MovieApiInterface
import com.use.api_do_imdb.api.MovieApiService
import com.use.api_do_imdb.databinding.ActivityMainBinding
import com.use.api_do_imdb.models.Movie
import com.use.api_do_imdb.models.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


// TODO -> DUVIDAS ABAIXO!

// 1- COMO CLICAR NUMA IMAGEM E IR PARA OUTRO FRAGMENT
// 2- PRECISO DE UM ADAPTER NOVO PARTE DE DETALHES DO FILME E O VER MAIS?