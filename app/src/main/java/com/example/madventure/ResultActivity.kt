package com.example.madventure

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.example.madventure.databinding.ActivityResultBinding

class ResultActivity : Activity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun take_result(view: android.view.View)
    {
        Toast.makeText(this,"Sucess",Toast.LENGTH_SHORT).show()
    }
}