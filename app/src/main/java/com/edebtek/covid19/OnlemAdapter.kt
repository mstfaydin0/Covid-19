package com.edebtek.covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnlemAdapter (var onlemList: ArrayList<Model>): RecyclerView.Adapter<OnlemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnlemAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return onlemList.size
    }

    override fun onBindViewHolder(holder: OnlemAdapter.ViewHolder, position: Int) {
        val semptomModel = onlemList[position]
        holder.bind(semptomModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_semptomlar,viewGroup,false)){

        fun bind(precautionsModel: Model){
            val semptomlarText = itemView.findViewById<TextView>(R.id.txtSemptoms)
            val semptomlarTextDetail = itemView.findViewById<TextView>(R.id.txtSymptomsDetay)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)

            imageView.setImageResource(precautionsModel.imageview)
            semptomlarText.text = precautionsModel.symptomsText
            semptomlarTextDetail.text = precautionsModel.symptomsDetail
        }

    }



}