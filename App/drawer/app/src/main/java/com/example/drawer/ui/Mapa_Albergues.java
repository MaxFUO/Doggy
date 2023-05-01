package com.example.drawer.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
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
import com.example.drawer.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapters.AlbergueAdapter;
import Entidades.Albergues;
import Utils.Utils;

public class Mapa_Albergues extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RecyclerView rcvListaAlbergues;

    ArrayList<Albergues> listaAlbergues;

    ProgressDialog progreso;

    RequestQueue requestQueue; //cola de requerimientos y se usa porque trabajamos en red
    JsonObjectRequest jsonObjectRequest; //objeto json para requerimientos
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_mapa__albergues, container, false);

        listaAlbergues = new ArrayList<>();
        rcvListaAlbergues = vista.findViewById(R.id.rcvListaAlbergues);
        rcvListaAlbergues.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvListaAlbergues.setHasFixedSize(true);
        requestQueue = Volley.newRequestQueue(getContext());
        cargarListaAlbergues();

        return vista;
    }

    private void cargarListaAlbergues() {
        progreso = new ProgressDialog(getContext());
        progreso.setMessage("Consultar Albergues");
        progreso.show();

        String url = Utils.RUTA + "consultaralbergue.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                this, this);
        requestQueue.add(jsonObjectRequest); //envia los datos
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onResponse(JSONObject respuesta) {
        progreso.hide();
        Toast.makeText(getContext(), "Listado Generado", Toast.LENGTH_SHORT).show();
        Albergues albergue = null;
        JSONArray json = respuesta.optJSONArray("albergue");

        try {
            for(int i=0;i<json.length();i++){
                albergue = new Albergues();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);
                albergue.setNombreAlb(jsonObject.getString("NombreAlb"));
                albergue.setHoraAperturaAlb(jsonObject.getString("HoraAperturaAlb"));
                listaAlbergues.add(albergue);
            }
            AlbergueAdapter adapter = new AlbergueAdapter(listaAlbergues);
            rcvListaAlbergues.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("ERROR",error.toString());
        progreso.setMessage("Error de carga");
        progreso.show();
    }
}