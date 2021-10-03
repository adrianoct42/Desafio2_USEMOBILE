package com.use.api_do_imdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.use.api_do_imdb.models.Movie
import kotlinx.android.synthetic.main.item_see_more.view.*

class SeeMoreAdapter(

    private val movies: List<Movie>
) : RecyclerView.Adapter<SeeMoreAdapter.SeeMoreViewHolder>() {

    class SeeMoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // QUARTO
        fun bindMovie(movie: Movie) {

            (itemView).texto_completo_seeMore.text = movie.title
            Glide
                .with(itemView)
                .load(movie.poster)
                .centerCrop()
                .into(itemView.poster_filme_seeMore)

        }
    }

    // SEGUNDO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeeMoreViewHolder {
        return SeeMoreViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_see_more, parent, false)
        )
    }

    // PRIMEIRO
    override fun getItemCount(): Int {
        return movies.size
    }

    // TERCEIRO
    override fun onBindViewHolder(holder: SeeMoreViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }
}