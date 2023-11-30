package com.example.styling

import android.os.Bundle
import android.text.method.DigitsKeyListener
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.styling.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            viewmodel = this@MainActivity.viewModel
        }
        setContentView(binding.root)
        viewModel.acceptableDigits.observe(this) {
            binding.text.keyListener = DigitsKeyListener.getInstance(it)
        }

        binding.button4.setOnClickListener {
            Log.e(MainActivity::class.java.name, viewModel.inputText.value.orEmpty())
        }
    }
}
