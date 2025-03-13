// TeamListActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView

class TeamListActivity : AppCompatActivity() {

    // Mock data for teams
    private val teamList = mutableListOf(
        Team("Equipo UX", "Diseño de interfaces"),
        Team("Equipo Frontend", "Desarrollo web"),
        Team("Equipo Backend", "Servicios API")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        // Setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvTeams)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TeamAdapter(teamList) { team ->
            // Handle team click - navigate to team details
            val intent = Intent(this, TeamDetailActivity::class.java)
            intent.putExtra("TEAM_NAME", team.name)
            startActivity(intent)
        }

        // Setup FAB
        val fabAddTeam = findViewById<FloatingActionButton>(R.id.btnAddTeam)
        fabAddTeam.setOnClickListener {
            // Show options dialog
            showTeamOptionsDialog()
        }
    }

    private fun showTeamOptionsDialog() {
        val options = arrayOf("Crear Equipo", "Unirme a Equipo")
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Opciones")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> startActivity(Intent(this, CreateTeamActivity::class.java))
                    1 -> startActivity(Intent(this, JoinTeamActivity::class.java))
                }
            }
            .show()
    }
}

// Team data class
data class Team(val name: String, val description: String)

// Team Adapter for RecyclerView
class TeamAdapter(
    private val teams: List<Team>,
    private val onTeamClick: (Team) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.cardTeam)
        val textName: TextView = view.findViewById(R.id.tvTeamName)
        val textDesc: TextView = view.findViewById(R.id.tvTeamDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.textName.text = team.name
        holder.textDesc.text = team.description
        holder.cardView.setOnClickListener { onTeamClick(team) }
    }

    override fun getItemCount() = teams.size
}