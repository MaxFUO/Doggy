package com.example.drawer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawer.R;

import java.util.List;

import com.example.drawer.Entidades.Albergues;

public class AlbergueAdapter extends RecyclerView.Adapter<AlbergueAdapter.AlbergueHolder>{
    List<Albergues> listaAlbergues;


    public AlbergueAdapter(List<Albergues> listaAlbergues) { this.listaAlbergues = listaAlbergues; }

    @NonNull
    @Override
    public AlbergueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.datosalbergue,
                parent, false);
        RecyclerView.LayoutParams formalayout = new RecyclerView.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(formalayout);
        return new AlbergueHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbergueHolder holder, int position) {
        //enlazados
        holder.txtNombreAlbergue.setText(listaAlbergues.get(position).getNombreAlb().toString());
//        holder.txtDistanciaAlbergue.setText("");
//        holder.txtEstadoAlbergue.setText("");
        holder.txtHoraAperturaAlbergue.setText(listaAlbergues.get(position).getHoraAperturaAlb().toString());
    }

    @Override
    public int getItemCount() { return listaAlbergues.size(); }


    public class AlbergueHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlbergue, txtDistanciaAlbergue, txtEstadoAlbergue, txtHoraAperturaAlbergue;

        ImageView imgLogoAlbergue;
        public AlbergueHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreAlbergue = itemView.findViewById(R.id.txtNombreAlbergue);
            txtDistanciaAlbergue = itemView.findViewById(R.id.txtDistanciaAlbergue);
            txtEstadoAlbergue = itemView.findViewById(R.id.txtEstadoAlbergue);
            txtHoraAperturaAlbergue = itemView.findViewById(R.id.txtHoraAperturaAlbergue);
            imgLogoAlbergue = itemView.findViewById(R.id.imgLogoAlbergue);
        }
    }
}
