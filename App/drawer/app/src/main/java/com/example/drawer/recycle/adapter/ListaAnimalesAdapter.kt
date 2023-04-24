package com.example.drawer.recycle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.recycle.ListaAnimales


class ListaAnimalesAdapter(private val animalesList: List<ListaAnimales>) :
    RecyclerView.Adapter<ListaAnimalesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAnimalesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaAnimalesViewHolder(
            layoutInflater.inflate(
                R.layout.item_lista_animal,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ListaAnimalesViewHolder, position: Int) {
        val item = animalesList[position]
        holder.render(item)


    }

    override fun getItemCount(): Int = animalesList.size


}