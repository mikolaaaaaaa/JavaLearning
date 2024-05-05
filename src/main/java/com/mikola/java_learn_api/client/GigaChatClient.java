package com.mikola.java_learn_api.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.request.ChatCompletionRequest;
import com.mikola.java_learn_api.service.GigaChatService;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GigaChatClient {

    private final ChatCompletionRequest chatCompletionRequest;
    private final GigaChatService gigaChatService;

    static {
        Unirest.config().verifySsl(false);
    }

    public String makeRequest(TaskDto task) throws JsonProcessingException {
        chatCompletionRequest.setMessages(gigaChatService.generateMessagesForCheckTask(task));

        Map<String,String> headers = new HashMap<>(ChatCompletionRequest.headers);
        headers.put("Authorization","eyJjdHkiOiJqd3QiLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.L_jz_MrSrS7zkaqcDY0t8hj7ahlcuOkOTJvO6_ry_q35b9vX0CFuu5nCGyhdtpADnsIQe1W8la856LhVNChB6BSKkFb9SYvpbKbX41T7MiHJzHYeGHw7RkKT1p-0kZH1kLrGE1i0NIKxB1jlaSXcNc0E1eDXYWpIdEvEaFuRfPOdXZ_-3GaGK3E5enayMcL_hi0hAqgJXLzqHC5gxre29x-M_i-y9jVEQPtZuhl80Vp5K8Hm5mR2G89IvK6_TLxhy8F99g2n5B-jtKo17-qr5QiCcQOm1tBuBSXoloENgBq1Z1Xj3m4eKXeYX2g7Zhzevm9ar8lwAnrWh5_YIeRfmw.rK7KuHC0c2QEp3jcWLZEVA.JPZoYzsF0vRr24r963nwivHFf5Z3nDkOCSH9yUb5hVIp5b3UMavnNt5jy3hqFPMNa44uxhLd6SfbD3vC-a1JMXsWB-B1JZg-UTmMI3yJWoMoGgTl6MmBl5Gaa_S-lQlYSTE2P9mzvpwGmI08k_BVERprYAcr4xYpm2PIPSGnx3FNf0U3hLAAMVM6HlQoIqU23ovcMWaBrR6cBOdb82yOAfFGMXXaXeINZ1ZRS8dBzKlSWX8gEjaTyrc5hF3mxpSFd8cNBwiMXtPIofusG7ukDjaV4hdDcOQ4UkIg8rtPK5PRQ0S5YKZcOvXdyzdC3Q4fsZWF7KZooCOR-OXCuJICrzPbW050K2zFfmkwp8PyoDDshODLG8yTE6e3BqU_LnIWEBZfe84zggUaXpc2632NS987NELI4dGXnTeVZDNZYoon2S48VaMRhR8K0X-BXoDsZHZYwfdCljjcGt82XC5JbKrL2i4TB81h-hBwG5ySEbJDDNSVU31bY_E51DJVmnS5BX9_eYas-JW-qApLhGEhD95Fd91DzF0U1ZvzXlVaJ7vU1lTlMwlzym_lzSIN1ZPkgj5Y-j1dGfxoB7pGXqOZvTzPd8WgmDxyERKEwWkacu4q9pjc5yTLMZ6-KmGDbAP5D4bXNuNwJLgWZ3bid9pMKggT3ahGYsTXSl7II0V4OLOTsUNZXAIXSDhjKufrljtoJA7Zv9TVpWYa7XI-4MOTCKPRnbB-hlTQ1huDSjgLIYg.NUw7Z6gZqbl2VlJna6rmRvNi91YfS0Gwyqcvy-DLu30");
        //add access token refresh
        HttpResponse<JsonNode> response = Unirest.post(ChatCompletionRequest.baseUrl + "/chat/completions")
                .headers(headers)
                .body( new ObjectMapper().writeValueAsString(chatCompletionRequest))
                .asJson();

        System.out.println(response);
        return response.getBody().toString();
    }

    public HttpResponse<JsonNode> getAccessToken() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        Unirest.config().verifySsl(false);
        return Unirest.post("https://ngw.devices.sberbank.ru:9443/api/v2/oauth")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .header("RqUID", "6f0b1291-c7f3-43c6-bb2e-9f3efb2dc98e")
                .header("Authorization", "Basic MDFlMjRjYTktYzQxNC00NjQ2LWFkM2ItYmZlMDA0YjEwYjJiOjVmNzRlMDk1LWMwMzctNGEzYS1hZDU3LWM3ZmM4NWU5OTY4NQ==")
                .field("scope", "GIGACHAT_API_PERS")
                .asJson();
    }

    public HttpResponse<String> getText() {
        Unirest.config().verifySsl(false);
//        return Unirest.post("https://gigachat.devices.sberbank.ru/api/v1/chat/completions")
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .header("Authorization", "Bearer eyJjdHkiOiJqd3QiLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.FZyUEmmWMLQT9VzJDotrpGu64FPT-ItGQ9gseRIK_4NtO9XpVoANPg-w7ST1oWasM3lv-_EKQJTmbLkmQ41W4DI3rLv6BOiNOR8K-dD1lT0aRQmwHzyqsDIprPS51QNdSSrFk1VX9k-uWSR0pSp5kDjBmSUd0k28uqT_ZEQQG_vuTMsAS-1cEH5DHtUJO_ZRMMPivei3t_8So3PzvCLVk4x0EPofvkblee8y3wNc8gIw89zuwOLJAtiD454GqULxBWSoUM7EWe7wBGwbPffiHKhpoEtk1wptI-EB2qlUxDTBd1QHrFqZpN70xOg02v2ujSACCrySDQ4rHWJ20CMc7w.mrkM6-bfQ-Iakh8RIljWyQ.za9atHKFOQyq_p77V8r-U7Cg_7yguCmjbeSUczBxR3Qc9ML4pWXPABPYQHazlmDEKAsYLU47hAP2sMXCopXnVYoSFLmnJoWmDDy8CioM2mPFlAZOjggYHhSyNKYHCKDMOgPM7eM74XUsJ9ZFKjUlUGMo64Kcwr043IyviOPPNJX0CaKYHWham6BwSLPLwA1sWv87AGF0yDjMuG8f0EVVhmAu7MSIyOcByEfnda7hhEolkfIGoc0n7Qos2l-iU85uR1Ms4eujhxqHnnIZhFGHNYhQxiluyCgJi5Q1mgzB-LIEJeVaUt0oCrQv4rOMr9qci3HlsESGjkKDWetH_7HTqA_V9f1_Gn_uiJ3fParQOrSA2newqfQjbimy7gKuitUaYQjUe0abI74SCCwwXKlpByLWCvdyb8CIQMa1E7VV4T65K1GVvl7fpXu_WgRrL1HhoKap5faS9A4MCB1ny_pIkgSm0hEIaLsCY6_hYQnta9PgN6iSPxAg3t7NuO6dIybnHm3L3NfS8BrEQl-yxVGvbuOe1zPvGWdH4xYGUhcE49LQTyrQ3p4vjU4BQ-xmc3aiGjUymUYKMjGQMBrYk9lrUC46Uz28WWaslhu-VVtcxA0g6cuac0zbn45rYbuThdFPGpu809XmK4Q7rSsTvzBRtqpZYRvGidT2EhhrefT2AlFvE2yYZbCJL6wMZRgliL01w6xT5g4Ai0nc6uGO-_eGDL12FGNA1vA9wmcQEYewD3w.8wkqjVnPDy381HVIUG8Be34ijZYEmAUyfcQBNN-KJDc")
//                .body("{\"model\": \"GigaChat:latest\",\n" +
//                        "  \"temperature\": 0.87, // от 0 до 2, чем выше, тем вывод более случайный, не рекомендуетсы использовать совместно c top_p\n" +
//                        "  \"top_p\": 0.47, // от 0 до 1, альтернатива параметру temperature, не рекомендуется использовать совместно c temperature\n" +
//                        "  \"n\": 1, // от 1 до 4, число вариантов ответов модели\n" +
//                        "  \"max_tokens\": 512, // максимальное число токенов для генерации ответов\n" +
//                        "  \"repetition_penalty\": 1.07, // количество повторений слов, 1.0 - ни чего не менять, от 0 до 1 повторять уже сказанные слова, от 1 и далее не использовать сказанные слова\n" +
//                        "  \"stream\": false, // если true, будут отправляться частичные ответы сообщений\n" +
//                        "  \"update_interval\": 0, // интервал в секундах, не чаще которого будут присылаться токены в stream режиме\n" +
//                        "  \"messages\": [\n" +
//                        "        {\n" +
//                        "            \"role\": \"system\", // контекст\n" +
//                        "            \"content\": \"Отвечай как научный сотрудник\"\n" +
//                        "        },\n" +
//                        "        {\n" +
//                        "            \"role\": \"user\", // запрос пользователя\n" +
//                        "            \"content\": \"Напиши 5 вариантов названий для космической станции\"\n" +
//                        "        }\n" +
//                        "/* пример с диалогом\n" +
//                        "        {\n" +
//                        "            \"role\": \"assistant\", // ответ модели\n" +
//                        "            \"content\": \"1. МИР 2. ЗЕМЛЯ 3. ЛУНА 4. НОВАЯ ЗЕМЛЯ 5. ПОЛЮС\"\n" +
//                        "        },\n" +
//                        "        {\n" +
//                        "            \"role\": \"user\", // запрос пользователя\n" +
//                        "            \"content\": \"А если представить, что они будут на Марсе?\"\n" +
//                        "        }\n" +
//                        "*/\n" +
//                        "    ]\n" +
//                        "}")
//                .asString();

        return Unirest.post("https://gigachat.devices.sberbank.ru/api/v1/chat/completions")
                .header("Content-Type", "application/json")
                .header("X-Request-ID", "79e41a5f-f180-4c7a-b2d9-393086ae20a1")
                .header("X-Session-ID", "b6874da0-bf06-410b-a150-fd5f9164a0b2")
                .header("X-Client-ID", "b6874da0-bf06-410b-a150-fd5f9164a0b2")
                .header("Authorization", "Bearer eyJjdHkiOiJqd3QiLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.FZyUEmmWMLQT9VzJDotrpGu64FPT-ItGQ9gseRIK_4NtO9XpVoANPg-w7ST1oWasM3lv-_EKQJTmbLkmQ41W4DI3rLv6BOiNOR8K-dD1lT0aRQmwHzyqsDIprPS51QNdSSrFk1VX9k-uWSR0pSp5kDjBmSUd0k28uqT_ZEQQG_vuTMsAS-1cEH5DHtUJO_ZRMMPivei3t_8So3PzvCLVk4x0EPofvkblee8y3wNc8gIw89zuwOLJAtiD454GqULxBWSoUM7EWe7wBGwbPffiHKhpoEtk1wptI-EB2qlUxDTBd1QHrFqZpN70xOg02v2ujSACCrySDQ4rHWJ20CMc7w.mrkM6-bfQ-Iakh8RIljWyQ.za9atHKFOQyq_p77V8r-U7Cg_7yguCmjbeSUczBxR3Qc9ML4pWXPABPYQHazlmDEKAsYLU47hAP2sMXCopXnVYoSFLmnJoWmDDy8CioM2mPFlAZOjggYHhSyNKYHCKDMOgPM7eM74XUsJ9ZFKjUlUGMo64Kcwr043IyviOPPNJX0CaKYHWham6BwSLPLwA1sWv87AGF0yDjMuG8f0EVVhmAu7MSIyOcByEfnda7hhEolkfIGoc0n7Qos2l-iU85uR1Ms4eujhxqHnnIZhFGHNYhQxiluyCgJi5Q1mgzB-LIEJeVaUt0oCrQv4rOMr9qci3HlsESGjkKDWetH_7HTqA_V9f1_Gn_uiJ3fParQOrSA2newqfQjbimy7gKuitUaYQjUe0abI74SCCwwXKlpByLWCvdyb8CIQMa1E7VV4T65K1GVvl7fpXu_WgRrL1HhoKap5faS9A4MCB1ny_pIkgSm0hEIaLsCY6_hYQnta9PgN6iSPxAg3t7NuO6dIybnHm3L3NfS8BrEQl-yxVGvbuOe1zPvGWdH4xYGUhcE49LQTyrQ3p4vjU4BQ-xmc3aiGjUymUYKMjGQMBrYk9lrUC46Uz28WWaslhu-VVtcxA0g6cuac0zbn45rYbuThdFPGpu809XmK4Q7rSsTvzBRtqpZYRvGidT2EhhrefT2AlFvE2yYZbCJL6wMZRgliL01w6xT5g4Ai0nc6uGO-_eGDL12FGNA1vA9wmcQEYewD3w.8wkqjVnPDy381HVIUG8Be34ijZYEmAUyfcQBNN-KJDc")
                .body("{\n  \"model\": \"GigaChat:latest\", \n  \"temperature\": 0.87, \n  \"top_p\": 0.47, \n  \"n\": 1, \n  \"max_tokens\": 512, \n  \"repetition_penalty\": 1.07, \n  \"stream\": false, \n  \"update_interval\": 0, \n  \"messages\": [\n        {\n            \"role\": \"system\", \n            \"content\": \"Отвечай как научный сотрудник\"\n        },\n        {\n            \"role\": \"user\", \n            \"content\": \"Напиши 5 вариантов названий для космической станции\"\n        }\n\n    ]\n}")
                .asString();
    }

}
