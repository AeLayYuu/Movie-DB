package com.wya.movieapp.ui.api

import com.wya.movieapp.ui.model.Detail
import com.wya.movieapp.ui.model.Play
import com.wya.movieapp.ui.model.Popular
import com.wya.movieapp.ui.model.Rated
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private var BASE_URL = " https://api.themoviedb.org/3/movie/"

    // https://api.themoviedb.org/3/movie/top_rated?api_key=<<f5b4b4a244942dc69732aa01528c2054>>&language=en-US&page=1
    companion object {
        var API_KEY = "f5b4b4a244942dc69732aa01528c2054"
    }

    private var apiInterface: ApiInterface

    init {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getRatedClient(
        apiKey: String,
        language: String,
        page: String
    ): Call<Rated> {
        return apiInterface.getRated(apiKey, language, page)
    }

    fun getPopularClient(
        apiKey: String,
        language: String,
        page: String
    ): Call<Popular> {
        return apiInterface.getPopular(apiKey, language, page)
    }

    fun getPlayClient(
        apiKey: String,
        language: String,
        page: String
    ): Call<Play> {
        return apiInterface.getPlay(apiKey, language, page)
    }

    fun getDetailClient(
        movieId: Int,
        apiKey: String,
        language: String
    ): Call<Detail> {
        return apiInterface.getDetail(movieId, apiKey, language)
    }
}