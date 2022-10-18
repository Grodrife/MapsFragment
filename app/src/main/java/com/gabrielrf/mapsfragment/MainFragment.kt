package com.gabrielrf.mapsfragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gabrielrf.mapsfragment.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply{
            recycler.adapter = ViajesAdapter(viajes) { viaje ->
                navigateTo(viaje)
            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "MapsFragment"
    }

    private fun navigateTo(viaje: Viaje){
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_right_in,
                R.anim.slide_left_out,
                R.anim.slide_left_in,
                R.anim.slide_right_out)
            .replace(R.id.fragment_container_view, DetailFragment.create(viaje))
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}

private val viajes = (1..100).map {
    Viaje(
        "https://loremflickr.com/240/320/city?lock=$it",
        "Nombre $it",
        "1${it}.414382,1${it}.013988"
    )
}