package com.example.happy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class FeelingAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var feelings = emptyList<Feeling>() // Cached copy of words

    inner class FeelingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewMode: TextView = itemView.findViewById(R.id.textViewMode)
        val textViewRemark: TextView = itemView.findViewById(R.id.textViewRemark)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelingViewHolder {
        val itemView = inflater.inflate(R.layout.recycle_view_item, parent, false)
        return FeelingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feelings.size
    }

    override fun onBindViewHolder(holder: FeelingViewHolder, position: Int) {
        val feelingRec: Feeling = feelings.get(position)

        holder.textViewMode.text = feelingRec.mode.toString()
        holder.textViewRemark.text = feelingRec.remarks
        holder.textViewDate.text = SimpleDateFormat("yyyy.MM.dd.HH:MM").format(feelingRec.created_at)
    }

    internal fun setFeeling(feeling: List<Feeling>) {
        this.feelings = feelings
    }
}