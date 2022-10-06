package com.ulp.login.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.login.MainActivity;
import com.ulp.login.model.Usuario;
import com.ulp.login.request.ApiClient;
import com.ulp.login.ui.registro.RegistroActivity;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mutableError;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<String> getMutableError() {
        if(mutableError == null) {
            mutableError = new MutableLiveData<>();
        }
        return mutableError;
    }

    public void login(String mail, String pass) {
        Usuario usuario = ApiClient.login(context, mail, pass);
        if(usuario != null) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

            Toast.makeText(context, "Sesion iniciada", Toast.LENGTH_SHORT).show();
        } else {
            mutableError.setValue("Usuario o contraseña incorrecta");
        }
    }

    public void registrar() {
        Intent i = new Intent(context, RegistroActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
