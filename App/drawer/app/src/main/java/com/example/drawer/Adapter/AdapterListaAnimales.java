package com.example.drawer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawer.Entidades.Animales;
import com.example.drawer.R;

import java.util.List;

public class AdapterListaAnimales extends RecyclerView.Adapter<AdapterListaAnimales.AnimalHolder> {
    List<Animales> listaAnimales;

    public AdapterListaAnimales(List<Animales> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }


    @NonNull
    @Override
    public AnimalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_animal,
                parent, false);
        RecyclerView.LayoutParams formalayout = new RecyclerView.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(formalayout);
        return new AnimalHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalHolder holder, int position) {
        //aqui obtienes la informacion guardada en la entidad
        //holder.txtNombreAlbergue.setText(listaAlbergues.get(position).getNombreAlb().toString());

        holder.txtnombreCachorro.setText(listaAnimales.get(position).getNombreAni());
        holder.txtDescripcionCachorro.setText(listaAnimales.get(position).getDescripcionAnim());

        if (listaAnimales.get(position).getImagenAnim() != null)
            holder.imgFotoMascota.setImageBitmap(listaAnimales.get(position).getImagenAnim());
//       else
//        holder.imgFotoMascota.setImageResource(R.drawable.img_gato_julian);
    }

    @Override
    public int getItemCount() {
        return listaAnimales.size();
    }

    public class AnimalHolder extends RecyclerView.ViewHolder {
        //aqui declaras los elementos java
        //ImageView imgLogoAlbergue;
        ImageView imgFotoMascota;
        TextView txtnombreCachorro, txtDescripcionCachorro;


        public AnimalHolder(@NonNull View itemView) {
            super(itemView);
            //aqui seteas haces referencia a los objetos xml con java
            //txtNombreAlbergue = itemView.findViewById(R.id.txtNombreAlbergue);


            txtnombreCachorro = itemView.findViewById(R.id.txtNombreCachorro1);
            txtDescripcionCachorro = itemView.findViewById(R.id.txtDescripcionCachorro);
            imgFotoMascota = itemView.findViewById(R.id.imgFotoMascota1);

        }
    }
}

