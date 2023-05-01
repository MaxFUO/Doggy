package com.example.drawer.ui.adopcionpanel;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PanelAdopcion extends Fragment {

     CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
     Button btnValidar, btnCancelar, btnEnProceso, btnAceptar, btnAceptar2,btnConsultar;
    TextView txtNombreMascota, txtNacimiento, txtGenero, txtRequiere, txtDescripcionMascota,txtIdMascota;
    RequestQueue requestQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pnl_adopcion, container, false);
        checkBox1 = view.findViewById(R.id.chkRequisito01);
        checkBox2 = view.findViewById(R.id.chkRequisito02);
        checkBox3 = view.findViewById(R.id.chkRequisito03);
        checkBox4 = view.findViewById(R.id.chkRequisito04);
        checkBox1.setOnCheckedChangeListener(checkBoxListener);
        checkBox2.setOnCheckedChangeListener(checkBoxListener);
        checkBox3.setOnCheckedChangeListener(checkBoxListener);
        checkBox4.setOnCheckedChangeListener(checkBoxListener);
        btnValidar = view.findViewById(R.id.btnAdoptar);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnEnProceso = view.findViewById(R.id.btnEnProceso);
        txtNombreMascota = view.findViewById(R.id.txtNombreMascota);
        txtNacimiento = view.findViewById(R.id.txtNacimiento);
        txtGenero = view.findViewById(R.id.txtGenero);
        txtRequiere = view.findViewById(R.id.txtRequiere);
        txtDescripcionMascota = view.findViewById(R.id.txtDescripcionMascota);
        txtIdMascota = view.findViewById(R.id.editTextIDAnimal);
        btnConsultar = view.findViewById(R.id.btnConsultar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnValidar.setVisibility(View.VISIBLE);
                btnCancelar.setVisibility(View.GONE);
                btnEnProceso.setVisibility(View.GONE);
                checkBox1.setEnabled(true);
                checkBox2.setEnabled(true);
                checkBox3.setEnabled(true);
                checkBox4.setEnabled(true);
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                Toast.makeText(getActivity(), "Su adopción ha sido cancelada", Toast.LENGTH_SHORT).show();

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buscarAnimales("http://192.168.1.19:80/doggy/buscar_datos.php?idAnimal="+txtIdMascota.getText()+"");
            }
        });

        return view;
    }

    CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            boolean todocheck = checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked();
            boolean nadacheck = checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked();

            if (todocheck) {
                btnValidar.setEnabled(true);
                btnValidar.setOnClickListener(v -> {
                    mostrarDialogoFelicidades();
                    btnCancelar.setVisibility(View.VISIBLE);
                    btnEnProceso.setVisibility(View.VISIBLE);
                    btnValidar.setVisibility(View.GONE);
                });
            } else if (nadacheck) {
                btnValidar.setEnabled(true);
                btnValidar.setOnClickListener(v -> mostrarRechazo());
            } else {
                btnValidar.setEnabled(true);
            }
        }
    };

    private void mostrarDialogoFelicidades() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_pnl_confirmacion, null);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        btnAceptar = dialogView.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                checkBox1.setEnabled(false);
                checkBox2.setEnabled(false);
                checkBox3.setEnabled(false);
                checkBox4.setEnabled(false);
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
            }
        });
        dialog.show();
    }

    private void mostrarRechazo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_pnl_rechazo, null);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        btnAceptar2 = dialogView.findViewById(R.id.btnAceptar2);
        btnAceptar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void buscarAnimales(String URL){
        JsonRequest jsonRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        txtIdMascota.setText(jsonObject.getString("IDAnimal"));
                        txtNombreMascota.setText(jsonObject.getString("NombreAni"));
                        txtNacimiento.setText(jsonObject.getString("EdadAni"));
                        txtGenero.setText(jsonObject.getString("RazaAni"));
                        txtRequiere.setText(jsonObject.getString("CuidadosEspeciales"));
                        txtDescripcionMascota.setText(jsonObject.getString("AlimentoFavorito"));
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"ERROR DE CONEXION",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonRequest);
    }
}
