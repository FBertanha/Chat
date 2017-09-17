package com.bertanha.chat.callback;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Felipe on 16/09/2017.
 */

public class EnviarMensagemCallback implements retrofit2.Callback<Void> {
    private String TAG = "EnviarMensagemCallback";

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {

    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());
    }
}
