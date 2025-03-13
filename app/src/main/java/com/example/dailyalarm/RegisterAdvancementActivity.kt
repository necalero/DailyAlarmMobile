// RegisterAdvancementActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterAdvancementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_advancement)

        // Get team name from intent
        val teamName = intent.getStringExtra("TEAM_NAME") ?: "Equipo"
        findViewById<TextView>(R.id.tvTeamName).text = teamName

        val etAdvancement = findViewById<EditText>(R.id.etAdvancement)
        val etPlan = findViewById<EditText>(R.id.etPlan)
        val etBlockers = findViewById<EditText>(R.id.etBlockers)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val advancement = etAdvancement.text.toString().trim()
            val plan = etPlan.text.toString().trim()
            val blockers = etBlockers.text.toString().trim()

            if (advancement.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu avance", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // For prototype, just go back to team detail
            Toast.makeText(this, "Avance registrado exitosamente", Toast.LENGTH_SHORT).show()

            // Return to team detail
            finish()
        }
    }
}