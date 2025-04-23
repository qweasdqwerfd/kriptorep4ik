package com.example.kriptorep4ik

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kriptorep4ik.ui_components.MainScreen


class MainActivity : ComponentActivity() {



    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Log.d("MainActivity", "До MainScreen()")
            MainScreen()
            Log.d("MainActivity", "После MainScreen()")
        }


    }
}

