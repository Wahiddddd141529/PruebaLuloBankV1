package com.lulo.test.api.dummyapi.task.get;

import com.lulo.test.api.dummyapi.Utilidades.Headers;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.ArrayList;
import java.util.HashMap;

import static com.lulo.test.api.dummyapi.constants.Constants.ENPOINT_GET_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GetUserTask implements Task {
    HashMap<String, Object> headers = new HashMap<>();
    Headers header;

    public static String id;

    public GetUserTask(){
        header=new Headers();
        headers=header.getHeaders();
    }

    public static Performable fromPage(){
        return instrumented(GetUserTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ENPOINT_GET_USER)
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .headers(headers)
                        )
        );
        ArrayList<String> listId = new ArrayList<String>();
        listId.add(SerenityRest.lastResponse().getBody().jsonPath().get("data").toString());
        id = listId.toString();
        id = id.substring(6, 30);
    }
}
