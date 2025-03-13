// MainActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // For the prototype, we'll directly start with the login screen
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}