package com.example.drawer.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.drawer.R;


public class MostrarAnimal extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    ImageButton btnPlay_Estadisticas, btnTiendaRopa, btnTiendaRegalos;
    TextView txtSkill1,txtSkill2,txtSkill3,txtBuff,txtDebilidad,txtNombre;

    public MostrarAnimal() {
        // Required empty public constructor
    }
    public static MostrarAnimal newInstance(String param1, String param2) {
        MostrarAnimal fragment = new MostrarAnimal();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mostrar_animal, container, false);
        btnPlay_Estadisticas = view.findViewById(R.id.btnPlay_Estadisticas);
        btnTiendaRopa = view.findViewById(R.id.btnTiendaRopa);
        btnTiendaRegalos = view.findViewById(R.id.btnTiendaRegalos);

        txtSkill1 = view.findViewById(R.id.txtSkill1);
        txtSkill2 = view.findViewById(R.id.txtSkill2);
        txtSkill3 = view.findViewById(R.id.txtSkill3);
        txtBuff = view.findViewById(R.id.txtBuff);
        txtDebilidad = view.findViewById(R.id.txtDebilidad);
        txtNombre = view.findViewById(R.id.txtNombre);

        //boton Estadisticas
        btnPlay_Estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlay_Estadisticas.setImageResource(R.drawable.boton_play_press);
            }
        });
        //boton Tienda de Ropa
        btnTiendaRopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTiendaRopa.setImageResource(R.drawable.boton_tienda_ropa_press);
            }
        });
        //boton Tienda de Regalos
        btnTiendaRegalos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTiendaRegalos.setImageResource(R.drawable.boton_regalo_tienda_press);
            }
        });
        return view;
    }
}