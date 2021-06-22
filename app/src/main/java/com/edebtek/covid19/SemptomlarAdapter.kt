package com.edebtek.covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SemptomlarAdapter(var list: ArrayList<Model>): RecyclerView.Adapter<SemptomlarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemptomlarAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SemptomlarAdapter.ViewHolder, position: Int) {
        val semptomlarModel = list[position]
        holder.bind(semptomlarModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_semptomlar,viewGroup,false)){

        fun bind(model: Model){
            val semptomText = itemView.findViewById<TextView>(R.id.txtSemptoms)
            val semptomlarTextDetail = itemView.findViewById<TextView>(R.id.txtSymptomsDetay)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(model.imageview)
            semptomText.text = model.symptomsText
            semptomlarTextDetail.text = model.symptomsDetail
        }

    }



}