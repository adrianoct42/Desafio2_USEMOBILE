package com.use.api_do_imdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.use.api_do_imdb.models.Movie
import kotlinx.android.synthetic.main.actors_details.view.*
import kotlinx.android.synthetic.main.fragment_details.view.*

class DetailsAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    class DetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // QUARTO
        fun bindMovie(movie: Movie) {

//            Glide
//                .with(itemView)
//                .load(movie.actors)
//                .centerCrop()
//                .into(itemView.foto_ator)
        }
    }

    // SEGUNDO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.actors_details, parent, false)
        )
    }

    // PRIMEIRO
    override fun getItemCount(): Int {
        return movies.size
    }

    // TERCEIRO
    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }
}
