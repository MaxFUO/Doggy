package com.example.drawer.Pojo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawer.R;

import java.util.List;

public class AlbergueImagenAdapter extends RecyclerView.Adapter<AlbergueImagenAdapter.AlbergueViewHolder> {

    private List<Albergue> albergueList;

    public AlbergueImagenAdapter(FragmentActivity activity, List<Albergue> albergueList) {
        this.albergueList = albergueList;
    }

    @NonNull
    @Override
    public AlbergueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.albergues_list_image, parent, false);
        return new AlbergueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbergueViewHolder holder, int position) {
        Albergue albergue = albergueList.get(position);
        holder.txtId.setText(String.valueOf(albergue.getId()));
        holder.txtNombre.setText(albergue.getNombre());
        holder.txtHoraApertura.setText(albergue.getHoraApertura());
        holder.txtDireccion.setText(albergue.getDireccion());
        holder.txtCorreoElectronico.setText(albergue.getCorreoElectronico());
        holder.imagen.setImageBitmap(albergue.getImagen());
    }

    @Override
    public int getItemCount() {
        return albergueList.size();
    }

    public static class AlbergueViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId, txtNombre, txtDireccion, txtCorreoElectronico, txtHoraApertura;
        private ImageView imagen;

        public AlbergueViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtHoraApertura = itemView.findViewById(R.id.txtHoraApertura);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);
            txtCorreoElectronico = itemView.findViewById(R.id.txtCorreoElectronico);
            imagen = itemView.findViewById(R.id.imagen);
        }
    }
}
