package com.example.rm

import android.app.Application

class RickAndMortyApp : Application() {
    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        const val CHARACTERS_ENDPOINT = "character"
    }
}

