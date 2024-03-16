package com.example.rm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var characterViewModel: CharacterViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        recyclerView = findViewById(R.id.r_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        characterViewModel.getCharacters()

        characterViewModel.characterData.observe(this) { characterData ->
            adapter = CharacterAdapter(characterData)
            recyclerView.adapter = adapter
        }
    }
}