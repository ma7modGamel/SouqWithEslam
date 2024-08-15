package com.safwatech.Souq

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.safwatech.Souq.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding
    private val SPLASH_DISPLAY_LENGTH = 2000L // 2 seconds
    override fun onCreate(savedInstanceState: Bundle?) {


        binding=ActivityMainBinding.inflate(layoutInflater)
        initSplash(SPLASH_DISPLAY_LENGTH)

        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }


    private fun   initSplash(SPLASH_DISPLAY_LENGTH: Long) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        } else {
            Handler().postDelayed({ binding.animationView.visibility = GONE },SPLASH_DISPLAY_LENGTH)
        }
    }
}