package com.bertanha.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.bertanha.chat.R;
import com.bertanha.chat.adapter.MensagemAdapter;
import com.bertanha.chat.modelo.Mensagem;
import com.bertanha.chat.service.ChatService;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int idDoCliente = 1;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listaDeMensagens = (ListView) findViewById(R.id.lv_mensagens);

        List<Mensagem> mensagens = Arrays.asList(new Mensagem(1, "Ola Mundo"), new Mensagem(2, "Holla Mundo"));

        MensagemAdapter adapter = new MensagemAdapter(this, mensagens, idDoCliente);

        listaDeMensagens.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.et_texto);

        button = (Button) findViewById(R.id.btn_enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ChatService().enviar(new Mensagem(idDoCliente, editText.getText().toString()));
            }
        });
    }
}
