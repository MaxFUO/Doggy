package com.example.drawer.Pojo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawer.R;

import java.util.List;

public class MisionesAdapter extends RecyclerView.Adapter<MisionesAdapter.MisionesHolder> {
    private List<Misiones> listaMisiones;

    public MisionesAdapter(List<Misiones> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }

    @NonNull
    @Override
    public MisionesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.tareas_list_image, parent, false);
        int spacing = 13;
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, spacing);
        vista.setLayoutParams(layoutParams);
        return new MisionesHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MisionesHolder holder, int position) {
        Misiones mision = listaMisiones.get(position);
        holder.txtId.setText(String.valueOf(mision.getIdMision()));
        holder.txtDescripcion.setText(mision.getDescripcion());
        holder.txtEstado.setText(mision.getEstado());
        holder.txtIdUsuario.setText(String.valueOf(mision.getIdUsuario()));
    }

    @Override
    public int getItemCount() {
        return listaMisiones.size();
    }

    public static class MisionesHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtDescripcion, txtEstado, txtIdUsuario;

        public MisionesHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_idmision);
            txtDescripcion = itemView.findViewById(R.id.txt_descripcion);
            txtEstado = itemView.findViewById(R.id.txt_estadoMision);
            txtIdUsuario = itemView.findViewById(R.id.txt_idusuario);
        }
    }
}
