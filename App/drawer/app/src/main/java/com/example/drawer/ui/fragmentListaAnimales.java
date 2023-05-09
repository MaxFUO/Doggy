package com.example.drawer.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
import java.util.Random;


public class fragmentListaAnimales extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject> {

    RecyclerView rcvListaAnimales;
    ArrayList<Animales> listaAnimales = new ArrayList<>();
    ProgressDialog progreso;

    AdapterListaAnimales adapterListaAnimales;

    RequestQueue requestQueue; //cola de requerimientos y se usa porque trabajamos en red
    JsonObjectRequest jsonObjectRequest; //objeto json para requerimientos


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        waitTask wt = new waitTask();
        wt.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_lista_animales, container, false);

        rcvListaAnimales = vista.findViewById(R.id.recyclerListaAnimales);

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

        //problema
        requestQueue.add(jsonObjectRequest); //envia los datos
        Toast.makeText(getContext(), jsonObjectRequest.toString(), Toast.LENGTH_SHORT).show();
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
                mascotas = new Animales(generateName());
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);


                mascotas.setNombreAni(jsonObject.getString("NombreAni"));

                //para probar
                Toast.makeText(getContext(), mascotas.getNombreAni(), Toast.LENGTH_SHORT).show();

                mascotas.setDescripcionAnim(jsonObject.getString("DescripcionAnim"));

                listaAnimales.add(mascotas);


            }

            AdapterListaAnimales adapter = new AdapterListaAnimales(listaAnimales);
            rcvListaAnimales.setAdapter(adapter);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String generateName(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 7;
        Random random = new Random();

        String generatedName = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedName;
    }


    public void generateEntities(){
        for(int i = 0; i<10; i++){
            listaAnimales.add(new Animales(generateName()));
        }
    }

    public void updateUI(ArrayList<Animales> animales){
        Log.d("inside", "updateUI");
        adapterListaAnimales = new AdapterListaAnimales(animales);
        rcvListaAnimales.setHasFixedSize(true);
        rcvListaAnimales.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvListaAnimales.setAdapter(adapterListaAnimales);

    }

    class waitTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(getContext());
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            generateEntities();
            try {
                Thread.sleep(5000);
            }
            catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            updateUI(listaAnimales);
            pd.dismiss();

            cargarListaAnimales();



        }
    }



}