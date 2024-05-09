package com.mikola.java_learn_api.client;


import com.mikola.java_learn_api.exception.ChatGptException;
import lombok.Cleanup;
import okhttp3.*;

import java.io.IOException;

public class ChatGptClient {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public String executeQuery(String prompt) {
        OkHttpClient client = new OkHttpClient();

        String apiKey = "";

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\": \"" + prompt + "\"}");

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        @Cleanup Response response = null;
        String responseBody;
        try {
            response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            throw new ChatGptException("Error during request with prompt " + prompt);
        }

        return responseBody;
    }
}
