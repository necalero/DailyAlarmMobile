// RegisterActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnConfirmRegister = findViewById<Button>(R.id.btnConfirmRegister)

        btnConfirmRegister.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Simple validation
            when {
                fullName.isEmpty() -> {
                    Toast.makeText(this, "Por favor ingresa tu nombre completo", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                email.isEmpty() -> {
                    Toast.makeText(this, "Por favor ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Por favor ingresa una contraseña", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // For prototype, just go to team listing
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            // Go to team listing
            val intent = Intent(this, TeamListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}