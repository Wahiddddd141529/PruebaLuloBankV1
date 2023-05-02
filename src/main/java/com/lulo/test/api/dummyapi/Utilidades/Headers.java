package com.lulo.test.api.dummyapi.Utilidades;

import java.util.HashMap;

public class Headers {

    HashMap<String,Object> headers = new HashMap<>();
    public Headers(){
        super();
        headers.put("app-id", "644f2dc7016e80c620113435");
    }

    public void setHeaders(HashMap<String, Object> headers) {
        this.headers = headers;
    }

    public HashMap<String, Object> getHeaders() {
        return headers;
    }
}
