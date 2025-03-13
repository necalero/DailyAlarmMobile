// TeamDetailActivity.kt
package com.example.dailyalarm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeamDetailActivity : AppCompatActivity() {

    // Mock data for advancements
    private val advancementList = mutableListOf(
        Advancement("Juan", "Diseñé la navegación principal", "Sin bloqueantes"),
        Advancement("María", "Implementé los prototipos de alta fidelidad", "Necesito feedback"),
        Advancement("Carlos", "Realicé pruebas de usabilidad", "Sin bloqueantes")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        // Get team name from intent
        val teamName = intent.getStringExtra("TEAM_NAME") ?: "Equipo"
        findViewById<TextView>(R.id.tvTeamName).text = teamName

        // Setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvAdvancements)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdvancementAdapter(advancementList)

        // Setup register advancement button
        val btnRegisterAdvancement = findViewById<Button>(R.id.btnRegisterAdvancement)
        btnRegisterAdvancement.setOnClickListener {
            val intent = Intent(this, RegisterAdvancementActivity::class.java)
            intent.putExtra("TEAM_NAME", teamName)
            startActivity(intent)
        }
    }
}

// Advancement data class
data class Advancement(val user: String, val progress: String, val blockers: String)

// Advancement Adapter
class AdvancementAdapter(
    private val advancements: List<Advancement>
) : RecyclerView.Adapter<AdvancementAdapter.AdvancementViewHolder>() {

    class AdvancementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textUser: TextView = view.findViewById(R.id.tvUserName)
        val textProgress: TextView = view.findViewById(R.id.tvProgress)
        val textBlockers: TextView = view.findViewById(R.id.tvBlockers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvancementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_advancement, parent, false)
        return AdvancementViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdvancementViewHolder, position: Int) {
        val advancement = advancements[position]
        holder.textUser.text = advancement.user
        holder.textProgress.text = "Avance: ${advancement.progress}"
        holder.textBlockers.text = "Bloqueantes: ${advancement.blockers}"
    }

    override fun getItemCount() = advancements.size
}