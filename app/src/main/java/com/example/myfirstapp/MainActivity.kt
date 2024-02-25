package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val chemicalNames = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener {
            val newChemical = binding.addText.text?.toString()
            if (!newChemical.isNullOrBlank()) {
                if (chemicalNames.contains(newChemical)) {
                    binding.status.text = "Chemical '$newChemical' is already available!"
                } else {
                    chemicalNames.add(newChemical)
                    binding.status.text = "Chemical '$newChemical' added successfully!"
                }
            }else {
                binding.status.text = "Enter a chemical name or guess:"
            }
        }

        binding.guess.setOnClickListener {
            if (chemicalNames.isNotEmpty()) {
                val randomChemical = chemicalNames[Random().nextInt(chemicalNames.size)]
                if (randomChemical == binding.guessText.text.toString()) {
                    binding.status.text = "Congratulations! You guessed it right. It was $randomChemical"
                } else {
                    binding.status.text = "Sorry, wrong guess. The correct answer was $randomChemical"
                }
            }else {
                binding.status.text = "Enter a chemical name or guess:"
            }
        }
    }
}