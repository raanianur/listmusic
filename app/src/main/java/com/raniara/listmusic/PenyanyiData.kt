package com.raniara.listmusic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PenyanyiData(
    val nama: String,
    val gambar: Int,
    val daftarLagu: List<LaguData>
) : Parcelable
