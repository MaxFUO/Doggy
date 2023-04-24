package com.example.drawer.recycle

import com.example.drawer.R


class ListaAnimalesProvider {
    companion object {
        val animalesList = listOf<ListaAnimales>(
            ListaAnimales(
                "ROCO",
                R.drawable.img_perro_cuate,
                R.drawable.ic_adoptar
            ),
            ListaAnimales(
                "LARISA",
                R.drawable.img_perro_pocho,
                R.drawable.ic_noadoptar
            ),
            ListaAnimales(
                "POCHO",
                R.drawable.img_perro_roco,
                R.drawable.ic_adoptar
            ),
            ListaAnimales(
                "CALMELL",
                R.drawable.img_gato_julian,
                R.drawable.ic_noadoptar
            ),

            )
    }
}