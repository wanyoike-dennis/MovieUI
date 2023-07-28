package com.example.practice.network

import com.example.practice.Movie

interface TMDBApi {

    suspend fun getPopularMovies(): List<Movie>
}