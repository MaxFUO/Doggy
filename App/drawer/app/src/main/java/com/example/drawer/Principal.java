package com.example.drawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.drawer.databinding.ActivityPrincipalBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Principal extends AppCompatActivity {

    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_mostaranimal, R.id.nav_mostraralbergue, R.id.nav_listaanimales,
                R.id.nav_inicio, R.id.nav_adopcion)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}