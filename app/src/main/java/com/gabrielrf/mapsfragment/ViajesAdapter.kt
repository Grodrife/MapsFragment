package com.gabrielrf.mapsfragment

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielrf.mapsfragment.databinding.ViewViajeItemBinding

class ViajesAdapter(val viajes: List<Viaje>, val listener: (Viaje) -> Unit): RecyclerView.Adapter<ViajesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_viaje_item,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viajes[position])
        holder.itemView.setOnClickListener {
            listener(viajes[position])
        }
    }

    override fun getItemCount(): Int = viajes.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewViajeItemBinding.bind(view)

        fun bind(viaje: Viaje){
            binding.imagen.loadUrl(viaje.imagen)
            binding.name.text = viaje.name
        }
    }
}