package com.gabrielrf.mapsfragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Viaje(val imagen : String, val name : String, val location: String): Parcelable{
}