package com.bertanha.chat.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Felipe on 13/09/2017.
 */

public class Mensagem {
    @SerializedName("text")
    private String texto;
    private int id;

    public Mensagem(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public int getId() {
        return id;
    }
}
