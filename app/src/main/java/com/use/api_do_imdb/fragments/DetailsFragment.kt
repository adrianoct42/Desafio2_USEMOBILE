package com.use.api_do_imdb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.use.api_do_imdb.DetailsAdapter
import com.use.api_do_imdb.MovieAdapter
import com.use.api_do_imdb.R
import com.use.api_do_imdb.api.MovieApiInterface
import com.use.api_do_imdb.api.MovieApiService
import com.use.api_do_imdb.databinding.FragmentDetailsBinding
import com.use.api_do_imdb.models.Movie
import com.use.api_do_imdb.models.MovieResponse
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.item_first_details.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var imageButton: ImageButton
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton = activity?.findViewById(R.id.back_btn_toolbar)!!
        imageButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.nomeFilmeDetalhado.text = args.nomeFilme
        binding.textoDaSinopse.text = args.sinopse
        Glide.with(view)
            .load(args.poster)
            .centerCrop()
            .into(binding.posterFilmeDetalhes)
        binding.elencoAtores.text = args.elenco


    }
}

//private fun getMovieData(callback: (List<Movie>) -> Unit) {
//    val apiService =
//        MovieApiService.getInstance().create(MovieApiInterface::class.java)
//    apiService.getMovieList().enqueue(
//        object : Callback<MovieResponse> {
//            override fun onResponse(
//                call: Call<MovieResponse>,
//                response: Response<MovieResponse>
//            ) {
//                return response.body()?.MOVIES_LISTA?.let { callback(it) }
//                    ?: callback(
//                        listOf()
//                    )
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            }
//        })
//}
