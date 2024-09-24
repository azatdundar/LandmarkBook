package com.azatdundar.landmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azatdundar.landmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)

    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarkList[position].name
        println("Binding position: $position -> ${landmarkList[position].name}") // just for trying



        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)

            intent.putExtra("landmark",landmarkList[position])

            holder.itemView.context.startActivity(intent)
            // We cannot call startActivity() directly here because we are not in an activity
        }


    }

    override fun getItemCount(): Int {
        println("Size of the landmarkList: " +landmarkList.size)
        return landmarkList.size

    }


}