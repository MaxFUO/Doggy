package com.example.drawer.ui.adopcionpanel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.drawer.R;

public class ComprarMonedas extends Fragment {
    CheckBox chk_pago_yape, chk_pago_plin;
    Button btnEnviarMoneda;
    EditText edtCantidadMonedas;
    TextView txtDinero;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comprar_monedas, container, false);

        chk_pago_yape = view.findViewById(R.id.chk_pago_yape);
        chk_pago_plin = view.findViewById(R.id.chk_pago_plin);
        btnEnviarMoneda = view.findViewById(R.id.btnEnviarMonedas);
        edtCantidadMonedas = view.findViewById(R.id.txtMonedas);
        txtDinero = view.findViewById(R.id.txtDinero);

        btnEnviarMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_pago_yape.isChecked()) {
                    ComprarMonedasDialogFragment dialogFragment = new ComprarMonedasDialogFragment();
                    dialogFragment.show(getFragmentManager(), "ComprarMonedasDialog");
                } else if (chk_pago_plin.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                    LayoutInflater inflater = requireActivity().getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.fragment_pago_plin, null);
                    builder.setView(dialogView);

                    Button btnEnviar = dialogView.findViewById(R.id.btnEnviar);
                    AlertDialog dialog = builder.create();

                    btnEnviar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Código para enviar las monedas usando Plin.
                            dialog.dismiss(); // Cerrar el diálogo
                        }
                    });
                    dialog.show();
                } else {
                    // Ninguna opción seleccionada, mostrar mensaje de error
                    Toast.makeText(getActivity(), "Debe seleccionar al menos una opción de pago", Toast.LENGTH_SHORT).show();
                }
            }
        });


        edtCantidadMonedas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se requiere implementación en este caso
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No se requiere implementación en este caso
            }

            @Override
            public void afterTextChanged(Editable s) {
                String cantidadMonedasStr = s.toString();
                if (!cantidadMonedasStr.isEmpty()) {
                    float cantidadMonedas = Integer.parseInt(cantidadMonedasStr);
                    float resultado = cantidadMonedas * 3;
                    txtDinero.setText(String.valueOf(resultado));
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

