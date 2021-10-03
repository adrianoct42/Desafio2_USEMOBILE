package com.use.api_do_imdb.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("fullTitle")
    val fullTitle: String,
    @SerializedName("image")
    val poster: String,
    @SerializedName("metacriticRating")
    val rating: String,
    @SerializedName("plot")
    val plot: String,
    @SerializedName("stars")
    val actors: String

) : Parcelable {
    constructor() : this("", "", "", "", "", "", "")
}
