package com.example.drawer.ui.ListadoAnimal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.Pojo.Animal;
import com.example.drawer.Pojo.AnimalImagenAdapter;
import com.example.drawer.Pojo.Util;
import com.example.drawer.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsultarListadoAnimal extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RecyclerView recycleAnimal;
    ArrayList<Animal> listaAnimal;

    SearchView searchView;

    ProgressDialog dialog;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_consultar_listado_animal, container, false);
        listaAnimal = new ArrayList<>();
        recycleAnimal = (RecyclerView) vista.findViewById(R.id.rcvListaAnimales);
        recycleAnimal.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recycleAnimal.setHasFixedSize(true);

        searchView = vista.findViewById(R.id.svMascotas);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });


        request = Volley.newRequestQueue(getContext());

        cargarWebservice();

        return vista;
    }

    private void cargarWebservice() {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Consultado con imagenes");
        dialog.show();

        String url = Util.RUTA + "consultarlistamascotas.php";
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        dialog.hide();
        Toast.makeText(getContext(), "Error al consultar" + error.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        dialog.hide();
        Animal mascota = null;
        JSONArray json = response.optJSONArray("animal");
        try {
            for (int i = 0; i < json.length(); i++) {
                mascota = new Animal();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                int id_animal = jsonObject.optInt("ID_Animal");
                mascota.setId(id_animal);

                String nombre = jsonObject.optString("NombreAni");
                mascota.setNombreAnimal(nombre);

                String descripcion = jsonObject.optString("DescripcionAnim");
                mascota.setDescripcionAnimal(descripcion);

                mascota.setDato(jsonObject.optString("ImagenAnim"));

                listaAnimal.add(mascota);
            }
            dialog.hide();
            AnimalImagenAdapter adapter = new AnimalImagenAdapter(listaAnimal);
            recycleAnimal.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "NO conexion con el servidor",
                    Toast.LENGTH_SHORT).show();
            dialog.hide();
        }
    }

    private void filter(String text) {
        ArrayList<Animal> filteredList = new ArrayList<>();

        if (text.isEmpty()) {
            filteredList.addAll(listaAnimal);
        } else {
            text = text.toLowerCase();

            for (Animal usuario : listaAnimal) {
                if (usuario.getNombreAnimal().toLowerCase().contains(text)) {
                    filteredList.add(usuario);
                }

            }
        }

        AnimalImagenAdapter adapter = new AnimalImagenAdapter(filteredList);
        recycleAnimal.setAdapter(adapter);
    }


}

