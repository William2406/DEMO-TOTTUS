package com.tottus.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tottus.R
import com.tottus.domain.entity.TeamDomain
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    var teamList: MutableList<TeamDomain>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        teamList?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = teamList?.size ?: 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(team: TeamDomain) = with(itemView) {
            nameText.text = team.name
        }
    }


}