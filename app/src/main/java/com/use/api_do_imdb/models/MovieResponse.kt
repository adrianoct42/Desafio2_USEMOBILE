package com.use.api_do_imdb.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("items")
    val MOVIES_LISTA : List<Movie>

) : Parcelable {
    constructor() : this(mutableListOf())
}