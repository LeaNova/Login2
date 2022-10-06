package com.ulp.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainViewModel;
    private TextView tvBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mainViewModel.getMutableSaludo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvBienvenida.setText(s);
            }
        });
        inicializarVista();
        mainViewModel.inicializarSaludo();
    }

    private void inicializarVista() {
        this.tvBienvenida = findViewById(R.id.tvBienvenida);
    }
}