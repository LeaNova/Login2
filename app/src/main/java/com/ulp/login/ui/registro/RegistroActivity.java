package com.ulp.login.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ulp.login.R;
import com.ulp.login.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private RegistroActivityViewModel registroViewModel;
    private EditText etDni, etApellido, etNombre, etMail, etPass;
    private Button btRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registroViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        inicializarVista();
    }

    private void inicializarVista() {
        this.etDni = findViewById(R.id.etDni);
        this.etApellido = findViewById(R.id.etApellido);
        this.etNombre = findViewById(R.id.etNombre);
        this.etMail = findViewById(R.id.etMail);
        this.etPass = findViewById(R.id.etPass);
        this.btRegistrarse = findViewById(R.id.btRegistrarse);
        this.btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long dni = Long.parseLong(etDni.getText().toString()+"");
                String apellido = etApellido.getText().toString();
                String nombre = etNombre.getText().toString();
                String mail = etMail.getText().toString();
                String pass = etPass.getText().toString();

                Usuario usuario = new Usuario(dni, apellido, nombre, mail, pass);
                registroViewModel.registrarse(usuario);
            }
        });
    }
}