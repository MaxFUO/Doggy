package com.example.drawer.Pojo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawer.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AnimalImagenAdapter extends RecyclerView.Adapter<AnimalImagenAdapter.AnimalesHolder> {

    List<Animal> listaAnimal;

    public AnimalImagenAdapter(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }


    @NonNull
    @Override
    public AnimalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_animales, parent,
                        false);
        RecyclerView.LayoutParams layoutParams = new
                RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        vista.setLayoutParams(layoutParams);
        return new AnimalesHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalesHolder holder, int position) {
        holder.txtId.setText(String.valueOf(listaAnimal.get(position).getId()));
        holder.txtNombre.setText(String.valueOf(listaAnimal.get(position).getNombreAnimal()));
        holder.txtDescripcion.setText(
                String.valueOf(listaAnimal.get(position).getDescripcionAnimal()));
        if (listaAnimal.get(position).getImagen() != null)
            holder.imagen.setImageBitmap(listaAnimal.get(position).getImagen());
        else
            holder.imagen.setImageResource(R.drawable.img_base);


    }

    @Override
    public int getItemCount() {
        return listaAnimal.size();

    }

    public class AnimalesHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtNombre, txtDescripcion;
        ImageView imagen;

        public AnimalesHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtIdAnimal);
            txtNombre = itemView.findViewById(R.id.txtNombreAnimal);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcionAnimal);
            imagen = itemView.findViewById(R.id.imgAnimal);
        }
    }

}
