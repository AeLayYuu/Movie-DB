package com.wya.movieapp.ui.api

import com.wya.movieapp.ui.model.Detail
import com.wya.movieapp.ui.model.Play
import com.wya.movieapp.ui.model.Popular
import com.wya.movieapp.ui.model.Rated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=f5b4b4a244942dc69732aa01528c2054&language=en-US&page=1
    //https://api.themoviedb.org/3/movie/top_rated?api_key=<<f5b4b4a244942dc69732aa01528c2054>>&language=en-US&page=1
    // https://api.themoviedb.org/3/movie/724089?api_key=f5b4b4a244942dc69732aa01528c2054&language=en-US
    //https://api.themoviedb.org/3/movie/latest?api_key=f5b4b4a244942dc69732aa01528c2054&language=en-US
    //https://api.themoviedb.org/3/movie/now_playing?api_key=f5b4b4a244942dc69732aa01528c2054&language=en-US&page=1
    @GET("now_playing")
    fun getPlay(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<Play>

    @GET("top_rated")
    fun getRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<Rated>

    @GET("popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<Popular>

    @GET("{movie_id}")
    fun getDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<Detail>
}