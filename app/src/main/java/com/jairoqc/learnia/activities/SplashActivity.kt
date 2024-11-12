package com.jairoqc.learnia.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jairoqc.learnia.R
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SplashScreen()
            LaunchedEffect(Unit) {
                delay(2000)
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish() // Cierra la SplashActivity
            }
        }
    }
}


@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ){
        Image(
            painter = painterResource(id = R.drawable.drawing),
            contentDescription = "App Logo"
        )
    }
}
