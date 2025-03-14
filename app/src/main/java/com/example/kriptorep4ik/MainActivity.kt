package com.example.kriptorep4ik

import android.annotation.SuppressLint
import android.os.Bundle
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
            MainScreen()

//            CoroutineScope(Dispatchers.IO).launch {
//                val svgPath = TestGraph().fetchDataWithSelenium()
//                Log.d("SVGPath", "SVG Path: $svgPath")
//            }
        }
    }
}

