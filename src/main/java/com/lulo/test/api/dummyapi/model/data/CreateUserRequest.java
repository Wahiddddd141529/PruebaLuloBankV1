package com.lulo.test.api.dummyapi.model.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateUserRequest {
    public static String body;

    public void bodyRequest(){
       body = "{\n" +
               "        \n" +
               "            \"firstName\": \"Julian-V21\",\n" +
               "            \"lastName\": \"VigesimaPrimera-Prueba\",\n" +
               "            \"email\": \"jv21@gmail.com\"\n" +
               "        \n" +
               "}";
    }


    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        CreateUserRequest.body = body;
    }
}
