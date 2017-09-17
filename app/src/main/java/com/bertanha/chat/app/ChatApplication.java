package com.bertanha.chat.app;

import android.app.Application;

import com.bertanha.chat.service.ChatService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Felipe on 17/09/2017.
 */

public class ChatApplication extends Application{

    public ChatService getChatService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.103:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatService chatService = retrofit.create(ChatService.class);
        return chatService;
    }
}
