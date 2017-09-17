package com.bertanha.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.bertanha.chat.R;
import com.bertanha.chat.adapter.MensagemAdapter;
import com.bertanha.chat.callback.EnviarMensagemCallback;
import com.bertanha.chat.callback.OuvirMensagensCallback;
import com.bertanha.chat.modelo.Mensagem;
import com.bertanha.chat.service.ChatService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private int idDoCliente = 1;
    private Button button;
    private EditText editText;
    private ChatService chatService;
    private ListView listaDeMensagens;
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeMensagens = (ListView) findViewById(R.id.lv_mensagens);

        editText = (EditText) findViewById(R.id.et_texto);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.103:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        chatService = retrofit.create(ChatService.class);

        ouvirMensagem();

        button = (Button) findViewById(R.id.btn_enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatService.enviar(new Mensagem(idDoCliente, editText.getText().toString())).enqueue(new EnviarMensagemCallback());
            }
        });
    }

    public void ouvirMensagem() {
        Call<Mensagem> call = chatService.ouvirMensagens();
        call.enqueue(new OuvirMensagensCallback(this));
    }

    public void colocaNaLista(Mensagem mensagem) {
        mensagens.add(mensagem);
        MensagemAdapter adapter = new MensagemAdapter(this, mensagens, idDoCliente);

        listaDeMensagens.setAdapter(adapter);

        ouvirMensagem();
    }
}
