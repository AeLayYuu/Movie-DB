package com.wya.movieapp.ui.model

data class Rated(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)