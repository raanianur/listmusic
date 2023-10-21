package com.raniara.fraglistmuic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PenyanyiViewModel : ViewModel(){
    private val _daftarPenyanyi = MutableLiveData<List<Singer>>()


    fun provideDaftarPenyanyi(){
         _daftarPenyanyi.value= listOf(
            Singer("Sia", R.drawable.sia, listOf(
                Song("Snowman", "Everyday Is Christmas"),
                Song("Chandelier", "1000 Forms of Fear"),
                Song("Genius ft Diplo, Labrinth", "LSD"),
                Song("Cheap Thrills ft Sean Paul", "This Is Acting"),
                Song("No New Friends ft Diplo, Labrinth", "LSD")
            )),
            Singer("Taylor Swift", R.drawable.taylor, listOf(
                Song("Shake it off", "1989"),
                Song("Style", "1989"),
                Song("Blank Space", "1989"),
                Song("Love Story", "Fearless"),
                Song("Red", "Red"),
                Song("22", "Red"),
                Song("Look What You Made Me Do", "Reputation"),
                Song("Back To December", "Speak Now")
            )),
            Singer("Raisa", R.drawable.raaisaa, listOf(
                Song("Usai di Sini", "Handmade"),
                Song("Kali Kedua", "Handmade"),
                Song("Mantan Terindah", "Raisa"),
                Song("Could it be", "Raisa"),
                Song("Terjebak Nostalgia", "Raisa"),
                Song("Teka-teki", "Raisa")
            )),
            Singer("Tulus", R.drawable.tulus, listOf(
                Song("Gajah", "Gajah"),
                Song("1000 Tahun Lamanya", "Single OST Tenggelamnya Kapal Van Der Wijck"),
                Song("Pamit", "Monokrom"),
                Song("Manusia Kuat", "Monokrom"),
                Song("Hati-Hati di Jalan", "Monokrom"),
                Song("Sepatu", "Sepatu"),
                Song("Baru", "Gajah")
            ))
        )
    }
    val daftarPenyanyi: LiveData<List<Singer>> get() = _daftarPenyanyi

    fun tambahPenyanyi(penyanyi: Singer) {
      //  _daftarPenyanyi.value?.add(penyanyi)
        _daftarPenyanyi.postValue(_daftarPenyanyi.value)
    }
}