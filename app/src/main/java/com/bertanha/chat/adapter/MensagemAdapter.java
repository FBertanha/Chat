package com.bertanha.chat.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bertanha.chat.R;
import com.bertanha.chat.modelo.Mensagem;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Felipe on 13/09/2017.
 */

public class MensagemAdapter extends BaseAdapter {

    private List<Mensagem> mensagens;
    private Activity activity;
    private int idDoCliente;

    public MensagemAdapter(Activity activity, List<Mensagem> mensagens, int idDoCliente) {
        this.activity = activity;
        this.mensagens = mensagens;
        this.idDoCliente = idDoCliente;
    }

    @Override
    public int getCount() {
        return mensagens.size();
    }

    @Override
    public Object getItem(int i) {
        return mensagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View linha = activity.getLayoutInflater().inflate(R.layout.mensagem, viewGroup, false);

        TextView texto = (TextView) linha.findViewById(R.id.tv_texto);

        Mensagem mensagem = (Mensagem) getItem(i);

        if (idDoCliente != mensagem.getId()) {
            linha.setBackgroundColor(Color.CYAN);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                linha.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            }
        }

        texto.setText(mensagem.getTexto());
        return linha;
    }
}
