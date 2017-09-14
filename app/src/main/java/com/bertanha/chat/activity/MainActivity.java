package com.bertanha.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bertanha.chat.R;
import com.bertanha.chat.adapter.MensagemAdapter;
import com.bertanha.chat.modelo.Mensagem;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int idDoCliente = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listaDeMensagens = (ListView) findViewById(R.id.lv_mensagens);

        List<Mensagem> mensagens = Arrays.asList(new Mensagem(1, "Ola Mundo"), new Mensagem(2, "Holla Mundo"));

        MensagemAdapter adapter = new MensagemAdapter(this, mensagens, idDoCliente);

        listaDeMensagens.setAdapter(adapter);
    }
}
