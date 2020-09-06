package com.wya.movieapp.ui.model

data class Popular(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)