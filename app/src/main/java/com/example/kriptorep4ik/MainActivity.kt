package com.example.kriptorep4ik

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kriptorep4ik.parse_data.graphs.TestGraph
import com.example.kriptorep4ik.ui_components.MainScreen


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()

            val svgPath = TestGraph().fetchDataWithSelenium()
            Log.d("SVGPath", "SVG Path: $svgPath")

        }
    }
}

