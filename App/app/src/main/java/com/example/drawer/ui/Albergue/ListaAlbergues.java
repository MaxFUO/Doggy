package com.example.drawer.ui.Albergue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.Pojo.Albergue;
import com.example.drawer.Pojo.AlbergueImagenAdapter;
import com.example.drawer.R;
import com.example.drawer.Util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaAlbergues extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    private RecyclerView recyclerAlbergues;
    private ArrayList<Albergue> listaAlbergues;
    private ProgressDialog progressDialog;
    private RequestQueue request;
    private JsonObjectRequest jsonObjectRequest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_albergues, container, false);

        listaAlbergues = new ArrayList<>();
        recyclerAlbergues = view.findViewById(R.id.RecyclerAlbergue);
        recyclerAlbergues.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAlbergues.setHasFixedSize(true);

        request = Volley.newRequestQueue(getActivity());
        cargarWebService();

        return view;
    }

    private void cargarWebService() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Consultando datos");
        progressDialog.show();

        String url = Util.RUTA + "listar_albergues.php";
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        progressDialog.hide();
        Albergue albergue = null;
        JSONArray json = response.optJSONArray("albergues");

        try {
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = json.getJSONObject(i);
                albergue = new Albergue();
                albergue.setId(jsonObject.getInt("id"));
                albergue.setNombre(jsonObject.getString("nombre"));
                albergue.setHoraApertura(jsonObject.getString("horaApertura"));
                albergue.setDireccion(jsonObject.getString("direccion"));
                albergue.setCorreoElectronico(jsonObject.getString("correoElectronico"));

                albergue.setDato(jsonObject.getString("imagen"));
                listaAlbergues.add(albergue);
            }

            AlbergueImagenAdapter adapter = new AlbergueImagenAdapter(getActivity(), listaAlbergues);
            recyclerAlbergues.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(getActivity(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
    }
}