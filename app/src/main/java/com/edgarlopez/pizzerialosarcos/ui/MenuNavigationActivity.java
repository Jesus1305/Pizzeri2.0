package com.edgarlopez.pizzerialosarcos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.edgarlopez.pizzerialosarcos.DesayunoActivity;
import com.edgarlopez.pizzerialosarcos.EnsaladasActivity;
import com.edgarlopez.pizzerialosarcos.HamburgesaActivity;
import com.edgarlopez.pizzerialosarcos.KidsActivity;
import com.edgarlopez.pizzerialosarcos.ListaPersonas2Recycler;
import com.edgarlopez.pizzerialosarcos.MariscoActivity;
import com.edgarlopez.pizzerialosarcos.NieveActivity;
import com.edgarlopez.pizzerialosarcos.PizzaActivity;
import com.edgarlopez.pizzerialosarcos.PlatillosActivity;
import com.edgarlopez.pizzerialosarcos.PostreActivity;
import com.edgarlopez.pizzerialosarcos.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void Pizzasact(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, PizzaActivity.class);
        startActivity(intent);
    }
    public void hamburgesa(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, HamburgesaActivity.class);
        startActivity(intent);
    }
    public void ensalada(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, EnsaladasActivity.class);
        startActivity(intent);
    }
    public void marisco(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, MariscoActivity.class);

        startActivity(intent);
    }
    public void platillos(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, PlatillosActivity.class);

        startActivity(intent);
    }
    public void desayuno (View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, DesayunoActivity.class);
        startActivity(intent);
    }
    public void bebidas(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, BebidaActivity.class);
        startActivity(intent);
    }
    public void postres(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, PostreActivity.class);
        startActivity(intent);
    }
    public void nieves(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, NieveActivity.class);
        startActivity(intent);
    }
    public void kids(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, KidsActivity.class);
        startActivity(intent);
    }

    public void carro(View t) {
        Intent intent = new Intent(MenuNavigationActivity.this, ListaPersonas2Recycler.class);
        startActivity(intent);
    }


}
