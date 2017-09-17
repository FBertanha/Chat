package com.bertanha.chat.callback;

import android.util.Log;

import com.bertanha.chat.activity.MainActivity;
import com.bertanha.chat.modelo.Mensagem;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Felipe on 16/09/2017.
 */

public class OuvirMensagensCallback implements retrofit2.Callback<Mensagem> {
    private MainActivity activity;
    private String LOG = "OuvirMensagensCallback";

    public OuvirMensagensCallback(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call<Mensagem> call, Response<Mensagem> response) {
        if(response.isSuccessful()) {
            Mensagem mensagem = response.body();
            activity.colocaNaLista(mensagem);
        }

    }

    @Override
    public void onFailure(Call<Mensagem> call, Throwable t) {
        Log.e(LOG, "onFailure: " + t.getMessage());
        activity.ouvirMensagem();
    }
}
