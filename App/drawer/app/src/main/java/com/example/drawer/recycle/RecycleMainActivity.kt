package com.example.drawer.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.databinding.ActivityMainBinding
import com.example.drawer.recycle.adapter.ListaAnimalesAdapter


class RecycleMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ListaAnimalesProvider.animalesList
        setContentView(R.layout.recycle_main_activity)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerListaAnimales)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListaAnimalesAdapter(ListaAnimalesProvider.animalesList)
    }
}