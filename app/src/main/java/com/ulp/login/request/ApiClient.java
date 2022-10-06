package com.ulp.login.request;

import android.content.Context;
import android.util.Log;

import com.ulp.login.model.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {
    private static File archivo;

    private static File conectar(Context context) {
        if(archivo == null) {
            File directorio = context.getFilesDir();
            archivo = new File(directorio, "usuario.dat");
        }
        return archivo;
    }

    public static void guardar(Context context, Usuario usuario) {
        try {
            File dato = conectar(context);

            FileOutputStream fOutput = new FileOutputStream(dato);
            BufferedOutputStream bOutput = new BufferedOutputStream(fOutput);
            ObjectOutputStream oOutput = new ObjectOutputStream(bOutput);

            oOutput.writeObject(usuario);

            bOutput.flush();
            fOutput.close();
        } catch (FileNotFoundException e) {
            Log.d("error", e.toString());
        } catch (IOException io) {
            Log.d("error", io.toString());
        }
    }

    public static Usuario leer(Context context) {
        Usuario usuario = null;
        try {
            File dato = conectar(context);
            FileInputStream fInput = new FileInputStream(dato);
            BufferedInputStream bInput = new BufferedInputStream(fInput);
            ObjectInputStream oInput = new ObjectInputStream(bInput);

            usuario = (Usuario) oInput.readObject();

            fInput.close();

        } catch (FileNotFoundException e) {
            Log.d("error", e.toString());
        } catch (IOException io) {
            Log.d("error", io.toString());
        } catch (ClassNotFoundException cn) {
            Log.d("error", cn.toString());
        }
        return usuario;
    }

    public static Usuario login(Context context, String mail, String pass) {
        Usuario usuario = null;
        try {
            File dato = conectar(context);
            FileInputStream fInput = new FileInputStream(dato);
            BufferedInputStream bInput = new BufferedInputStream(fInput);
            ObjectInputStream oInput = new ObjectInputStream(bInput);

            Usuario u = (Usuario) oInput.readObject();

            if(u.getMail().equals(mail) && u.getPassword().equals(pass)) {
                usuario = u;
            }

            fInput.close();
        } catch (FileNotFoundException e) {
            Log.d("error", e.toString());
        } catch (IOException io) {
            Log.d("error", io.toString());
        } catch (ClassNotFoundException cn) {
            Log.d("error", cn.toString());
        }

        return usuario;
    }
}






