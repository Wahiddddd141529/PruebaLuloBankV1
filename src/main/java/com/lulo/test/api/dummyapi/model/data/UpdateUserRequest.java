package com.lulo.test.api.dummyapi.model.data;

public class UpdateUserRequest {
    public static String body;

    public void bodyUpdateRequest(){
        body = "{\n" +
                "    \"phone\": \"(890)-854-5524\"\n" +
                "}";
    }

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        UpdateUserRequest.body = body;
    }
}
