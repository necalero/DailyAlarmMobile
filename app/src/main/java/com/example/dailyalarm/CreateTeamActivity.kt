// CreateTeamActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_team)

        val etTeamName = findViewById<EditText>(R.id.etTeamName)
        val etTeamDescription = findViewById<EditText>(R.id.etTeamDescription)
        val btnCreateTeam = findViewById<Button>(R.id.btnCreateTeam)

        btnCreateTeam.setOnClickListener {
            val teamName = etTeamName.text.toString().trim()
            val teamDesc = etTeamDescription.text.toString().trim()

            if (teamName.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa un nombre para el equipo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // For prototype, just go back to team listing
            // In a real app, we would save this team to a database
            Toast.makeText(this, "Equipo creado exitosamente", Toast.LENGTH_SHORT).show()

            // Return to team listing
            val intent = Intent(this, TeamListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}