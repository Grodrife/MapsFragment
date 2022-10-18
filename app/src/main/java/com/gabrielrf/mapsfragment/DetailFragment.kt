package com.gabrielrf.mapsfragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gabrielrf.mapsfragment.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail){

    companion object{
        const val EXTRA_VIAJE = "DetailActivity:Viaje"

        fun create(viaje: Viaje): DetailFragment = DetailFragment().apply {
            arguments = bundleOf(EXTRA_VIAJE to viaje)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.inflate(layoutInflater)

        val viaje = arguments?.getParcelable<Viaje>(EXTRA_VIAJE) ?: throw IllegalStateException()

        val gmmIntentUri = Uri.parse("geo:${viaje.location.toString()}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = viaje.name

        binding.name.text = viaje.name

        binding.imagen.loadUrl(viaje.imagen)
    }
}