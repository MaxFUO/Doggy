package com.example.drawer.ui.Misiones;

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
import com.example.drawer.Pojo.Misiones;
import com.example.drawer.Pojo.MisionesAdapter;
import com.example.drawer.R;
import com.example.drawer.Util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaMisiones extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    private RecyclerView recyclerMisiones;
    private ArrayList<Misiones> listaMisiones;
    private ProgressDialog progressDialog;
    private RequestQueue request;
    private JsonObjectRequest jsonObjectRequest;
    private MisionesAdapter misionesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_misiones, container, false);

        listaMisiones = new ArrayList<>();
        recyclerMisiones = view.findViewById(R.id.recyclerMisiones);
        recyclerMisiones.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerMisiones.setHasFixedSize(true);

        request = Volley.newRequestQueue(getActivity());
        cargarWebService();

        return view;
    }

    private void cargarWebService() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Consultando datos");
        progressDialog.show();

        String url = Util.RUTA + "lista_misiones.php?idUsuario=1";
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        listaMisiones.clear();
        try {
            JSONArray jsonArray = response.getJSONArray("misiones");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Misiones mision = new Misiones();
                mision.setIdUsuario(jsonObject.getInt("idUsuario"));
                mision.setIdMision(jsonObject.getInt("idMision"));
                mision.setDescripcion(jsonObject.getString("descripcion"));
                mision.setEstado(jsonObject.getString("estado"));

                listaMisiones.add(mision);
            }
            misionesAdapter = new MisionesAdapter(listaMisiones);
            recyclerMisiones.setAdapter(misionesAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
        }
        progressDialog.dismiss();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(getActivity(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
    }
}
