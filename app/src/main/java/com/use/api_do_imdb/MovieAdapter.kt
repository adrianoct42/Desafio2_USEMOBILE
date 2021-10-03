package com.use.api_do_imdb

import android.util.TypedValue
import android.util.TypedValue.*
import com.use.api_do_imdb.models.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_first_details.view.*
import kotlinx.android.synthetic.main.fragment_details.view.*

class MovieAdapter(
    private val movies: List<Movie>, private val function: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // QUARTO
        fun bindMovie(movie: Movie) {
            itemView.nome_filme_main.text = movie.title
            Glide
                .with(itemView)
                .load(movie.poster)
                .centerCrop()
                .into(itemView.poster_filme_main)
        }
    }

    // SEGUNDO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_first_details, parent, false)
        )
    }

    // PRIMEIRO
    override fun getItemCount(): Int {
        return movies.size
    }

    // TERCEIRO
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
        holder.itemView.setOnClickListener {
            function(movies[position])
        }
    }
}