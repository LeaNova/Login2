package com.ulp.login.ui.registro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulp.login.model.Usuario;
import com.ulp.login.request.ApiClient;

public class RegistroActivityViewModel extends AndroidViewModel {
    private Context context;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public void registrarse(Usuario usuario) {
        ApiClient.guardar(context, usuario);

        Toast.makeText(context, "Usuario registrado", Toast.LENGTH_SHORT).show();
        System.exit(0);
    }
}
