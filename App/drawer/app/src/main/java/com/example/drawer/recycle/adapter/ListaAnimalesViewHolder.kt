package com.example.drawer.recycle.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.recycle.ListaAnimales


class ListaAnimalesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val nombreCachorro = view.findViewById<TextView>(R.id.txtNombreCachorro1)
    val imageCachorro = view.findViewById<ImageView>(R.id.imgFotoMascota1)
    val iconoAdopcion = view.findViewById<ImageView>(R.id.imgAdopcion)

    fun render(listaAnimalesModel: ListaAnimales) {
        nombreCachorro.text = listaAnimalesModel.listNombre
        imageCachorro.setImageResource(
            listaAnimalesModel.listImagen
        )

    }
}