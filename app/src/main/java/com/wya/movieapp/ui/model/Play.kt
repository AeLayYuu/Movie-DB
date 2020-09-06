package com.wya.movieapp.ui.model

data class Play(
    val dates: Dates,
    val page: Int,
    val results: List<ResultXX>,
    val total_pages: Int,
    val total_results: Int
)