package com.ulp.login.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ulp.login.R;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityViewModel loginViewModel;
    private EditText etMail, etPass;
    private TextView tvError;
    private Button btEntrar, btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        loginViewModel.getMutableError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvError.setText(s);
            }
        });
        inicializarVista();
    }

    private void inicializarVista() {
        this.etMail = findViewById(R.id.etMailL);
        this.etPass = findViewById(R.id.etPassL);
        this.tvError = findViewById(R.id.tvErrorL);

        this.btEntrar = findViewById(R.id.btEntrar);
        this.btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = etMail.getText().toString();
                String pass = etPass.getText().toString();
                loginViewModel.login(mail, pass);
            }
        });
        this.btRegistrar = findViewById(R.id.btRegistrar);
        this.btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.registrar();
            }
        });
    }
}