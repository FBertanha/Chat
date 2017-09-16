package com.bertanha.chat.service;

import com.bertanha.chat.modelo.Mensagem;

import org.json.JSONStringer;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Felipe on 14/09/2017.
 */

public class ChatService {


    public void enviar(final Mensagem mensagem) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String texto = mensagem.getTexto();

                try {
                    HttpURLConnection httpConnection = (HttpURLConnection) new URL("http://192.168.1.103:8080/polling").openConnection();
                    httpConnection.setRequestMethod("POST");

                    httpConnection.setRequestProperty("content-type", "application/json");

                    JSONStringer json = new JSONStringer()
                            .object()
                            .key("text")
                            .value(texto)
                            .key("id")
                            .value(mensagem.getId())
                            .endObject();

                    OutputStream saida = httpConnection.getOutputStream();
                    PrintStream ps = new PrintStream(saida);
                    ps.println(json.toString());

                    httpConnection.connect();
                    httpConnection.getInputStream();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
