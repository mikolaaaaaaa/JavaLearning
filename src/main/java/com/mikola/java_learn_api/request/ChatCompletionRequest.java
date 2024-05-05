package com.mikola.java_learn_api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
public class ChatCompletionRequest {
    @JsonProperty("model")
    private String model = "GigaChat:latest";

    @JsonProperty("temperature")
    private double temperature = 0.87;

    @JsonProperty("top_p")
    private double topP = 0.47;

    @JsonProperty("n")
    private int n = 1;

    @JsonProperty("max_tokens")
    private int maxTokens = 512;

    @JsonProperty("repetition_penalty")
    private double repetitionPenalty = 1.07;

    @JsonProperty("stream")
    private boolean stream = false;

    @JsonProperty("update_interval")
    private int updateInterval = 0;

    @JsonProperty("messages")
    private List<Message> messages;

    public static final String baseUrl = "https://gigachat.devices.sberbank.ru/api/v1/";

    public static final Map<String,String> headers = Map.of(
            "Content-Type", "application/json",
            "X-Request-ID", "79e41a5f-f180-4c7a-b2d9-393086ae20a1",
            "X-Session-ID", "b6874da0-bf06-410b-a150-fd5f9164a0b2",
            "X-Client-ID", "b6874da0-bf06-410b-a150-fd5f9164a0b2",
            "Authorization", ""
    );



}

