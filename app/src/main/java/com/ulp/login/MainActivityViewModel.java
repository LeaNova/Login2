package com.ulp.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.login.model.Usuario;
import com.ulp.login.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mutableSaludo;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<String> getMutableSaludo() {
        if(mutableSaludo == null) {
            mutableSaludo = new MutableLiveData<>();
        }
        return mutableSaludo;
    }

    public void inicializarSaludo() {
        Usuario usuario = ApiClient.leer(context);
        String saludo = "Hola " + usuario.getNombre() + " " + usuario.getApellido();
        mutableSaludo.setValue(saludo);
    }
}
