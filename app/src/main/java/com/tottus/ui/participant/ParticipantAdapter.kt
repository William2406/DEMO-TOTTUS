package com.tottus.ui.participant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tottus.R
import com.tottus.domain.entity.ParticipantDomain
import kotlinx.android.synthetic.main.item_participant.view.*

class ParticipantAdapter : RecyclerView.Adapter<ParticipantAdapter.ViewHolder>() {

    var listParticipants: MutableList<ParticipantDomain>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_participant, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listParticipants?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listParticipants?.size ?: 0


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(participant: ParticipantDomain) = with(itemView) {
            nameText.text = participant.name
        }
    }
}