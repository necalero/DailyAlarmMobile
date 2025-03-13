// RecoverAccountActivity.kt
package com.example.dailyalarm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoverAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_account)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnRecover = findViewById<Button>(R.id.btnRecover)

        btnRecover.setOnClickListener {
            val email = etEmail.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // For prototype, just show a toast
            Toast.makeText(this, "Se ha enviado un correo de recuperación a $email", Toast.LENGTH_LONG).show()

            // Return to login
            finish()
        }
    }
}