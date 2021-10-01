package com.use.api_do_imdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.use.api_do_imdb.MovieAdapter
import com.use.api_do_imdb.R
import com.use.api_do_imdb.api.MovieApiInterface
import com.use.api_do_imdb.api.MovieApiService
import com.use.api_do_imdb.databinding.FragmentFirstBinding
import com.use.api_do_imdb.models.Movie
import com.use.api_do_imdb.models.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_see_more.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var imageButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton = activity?.findViewById(R.id.back_btn_toolbar)!!
        imageButton.setOnClickListener {
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentSelf()
            )
        }

        getMovieData { movies: List<Movie> ->
            recycle_forYou.adapter = MovieAdapter(movies.take(5)) {
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToDetailsFragment()
                )
            }
        }
        getMovieData { movies: List<Movie> ->
            recycle_action.adapter = MovieAdapter(movies.take(5)) {
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToDetailsFragment()
                )
            }
        }
        getMovieData { movies: List<Movie> ->
            recycle_drama.adapter = MovieAdapter(movies.take(5)) {
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToDetailsFragment()
                )
            }
        }

    }
}

private fun getMovieData(callback: (List<Movie>) -> Unit) {
    val apiService =
        MovieApiService.getInstance().create(MovieApiInterface::class.java)
    apiService.getMovieList().enqueue(
        object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return response.body()?.MOVIES_LISTA?.let { callback(it) }
                    ?: callback(
                        listOf()
                    )
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })
}
