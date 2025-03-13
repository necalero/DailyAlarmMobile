// JoinTeamActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JoinTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_team)

        val etTeamCode = findViewById<EditText>(R.id.etTeamCode)
        val btnJoinTeam = findViewById<Button>(R.id.btnJoinTeam)

        btnJoinTeam.setOnClickListener {
            val teamCode = etTeamCode.text.toString().trim()

            if (teamCode.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa un código de equipo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // For prototype, just go back to team listing
            Toast.makeText(this, "Te has unido al equipo exitosamente", Toast.LENGTH_SHORT).show()

            // Return to team listing
            val intent = Intent(this, TeamListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}