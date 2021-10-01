package com.use.api_do_imdb.api

import com.use.api_do_imdb.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("API/ComingSoon/k_caojwirh")
    fun getMovieList(): Call<MovieResponse>
}