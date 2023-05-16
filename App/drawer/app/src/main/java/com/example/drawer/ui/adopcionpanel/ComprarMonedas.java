package com.example.drawer.ui.adopcionpanel;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.drawer.R;

public class ComprarMonedas extends Fragment {
    CheckBox chk_pago_yape,chk_pago_plin;
    Button btnEnviarMoneda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comprar_monedas, container, false);

        chk_pago_yape = view.findViewById(R.id.chk_pago_yape);
        chk_pago_plin = view.findViewById(R.id.chk_pago_plin);
        btnEnviarMoneda = view.findViewById(R.id.btnEnviarMonedas);
        btnEnviarMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_pago_yape.isChecked()) {
                    ComprarMonedasDialogFragment dialogFragment = new ComprarMonedasDialogFragment();
                    dialogFragment.show(getFragmentManager(), "ComprarMonedasDialog");
                } else {
                    // Código para enviar las monedas usando otro método de pago.
                }
            }
        });

        chk_pago_yape.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_pago_plin.setChecked(false);
                    chk_pago_plin.setEnabled(false);
                } else {
                    chk_pago_plin.setEnabled(true);
                }
            }
        });

        chk_pago_plin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chk_pago_yape.setChecked(false);
                    chk_pago_yape.setEnabled(false);
                } else {
                    chk_pago_yape.setEnabled(true);
                }
            }
        });

        return view;
    }

    public static class ComprarMonedasDialogFragment extends DialogFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_comprar_yape, container, false);

            Button btnEnviar = view.findViewById(R.id.btnEnviar);
            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Código para enviar las monedas usando Yape.
                    dismiss();
                }
            });
            return view;
        }
    }
}

