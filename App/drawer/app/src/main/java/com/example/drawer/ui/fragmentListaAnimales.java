package com.example.drawer.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.Adapter.AdapterListaAnimales;
import com.example.drawer.Entidades.Animales;
import com.example.drawer.R;
import com.example.drawer.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class fragmentListaAnimales extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject> {

    RecyclerView rcvListaAnimales;
    ArrayList<Animales> listaAnimales;
    ProgressDialog progreso;

    RequestQueue requestQueue; //cola de requerimientos y se usa porque trabajamos en red
    JsonObjectRequest jsonObjectRequest; //objeto json para requerimientos


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public fragmentListaAnimales() {
        // Required empty public constructor
    }


    public static fragmentListaAnimales newInstance(String param1, String param2) {
        fragmentListaAnimales fragment = new fragmentListaAnimales();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_lista_animales, container, false);
        listaAnimales = new ArrayList<>();

        rcvListaAnimales = vista.findViewById(R.id.recyclerListaAnimales);
        rcvListaAnimales.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvListaAnimales.setHasFixedSize(true);
        requestQueue = Volley.newRequestQueue(getContext());
        cargarListaAnimales();
        return vista;

    }

    private void cargarListaAnimales() {
        progreso = new ProgressDialog(getContext());
        progreso.setMessage("Consultar Animales");
        progreso.show();

        String url = Utils.RUTA + "consultar_animal.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                this, this);
        requestQueue.add(jsonObjectRequest); //envia los datos
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //sucede un error

        Log.i("ERROR",error.toString());
        progreso.setMessage("Error de carga");
        progreso.show();

    }

    @Override
    public void onResponse(JSONObject response) {
        //obtención de datos

        progreso.hide();
        Toast.makeText(getContext(), "Listado Generado", Toast.LENGTH_SHORT).show();
        Animales mascotas = null;
        JSONArray json = response.optJSONArray("animal");

        try {
            for (int i = 0; i < json.length(); i++) {
                mascotas = new Animales();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);
//                albergue.setIDAlbergue(jsonObject.getInt("IDAlbergue"));

                mascotas.setNombreAni(jsonObject.getString("NombreAni"));
                Toast.makeText(getContext(), mascotas.getNombreAni(), Toast.LENGTH_SHORT).show();
//                albergue.setLatitudAlb(jsonObject.getString("LatitudAlb"));
//                albergue.setLongitudAlb(jsonObject.getString("LongitudAlb"));
                mascotas.setDescripcionAnim(jsonObject.getString("DescripcionAnim"));

                listaAnimales.add(mascotas);
            }
            AdapterListaAnimales adapter = new AdapterListaAnimales(listaAnimales);
            rcvListaAnimales.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}