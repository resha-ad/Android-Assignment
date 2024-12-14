package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.RecyclerAdapter
import com.example.myapplication.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding

    // Data for RecyclerView
    private val imageList = arrayListOf(
        R.drawable.daisy, R.drawable.rose, R.drawable.tulip,R.drawable.lavenders,R.drawable.orchids,
        R.drawable.poppies, R.drawable.sunflower, R.drawable.iris
    )
    private val titleList = arrayListOf("Daisy", "Rose", "Tulip","Lavender","Orchid","Poppy","Sunflower","Iris")
    private val descList = arrayListOf(
        "These are daisies", "These are roses", "These are tulips", "These are lavenders", 
        "These are orchids", "These are poppies", "These are sunflowers", "These are irises",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve Data from Intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")

        // Display Received Data
        binding.nameDisplay.text = name
        binding.emailDisplay.text = email
        binding.genderDisplay.text = gender
        binding.countryDisplay.text = country
        binding.cityDisplay.text = city

        // RecyclerView Setup
        val adapter = RecyclerAdapter(imageList, titleList, descList)
        binding.recycler.layoutManager = GridLayoutManager(this, 2)
        binding.recycler.adapter = adapter
    }
}
