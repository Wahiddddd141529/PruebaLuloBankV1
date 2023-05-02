package com.lulo.test.api.dummyapi.task.put;

import com.lulo.test.api.dummyapi.Utilidades.Headers;
import com.lulo.test.api.dummyapi.model.data.UpdateUserRequest;
import com.lulo.test.api.dummyapi.task.post.PostCreateUserTask;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.ArrayList;
import java.util.HashMap;

import static com.lulo.test.api.dummyapi.constants.Constants.ENPOINT_USER_ID;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUpdateUserTask implements Task {

    HashMap<String, Object> headers = new HashMap<>();
    Headers header;
    public static String phone;
    UpdateUserRequest updateUserRequest = new UpdateUserRequest();
    public PutUpdateUserTask(){
        header=new Headers();
        headers=header.getHeaders();
        updateUserRequest.bodyUpdateRequest();
    }

    public static Performable fromPage() {
        return instrumented(PutUpdateUserTask.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    //Dado que es la misma URL que se maneja para actualizar el usuario
                    Put.to(ENPOINT_USER_ID)
                            .with(requestSpecification -> requestSpecification
                                    .relaxedHTTPSValidation()
                                    .contentType(ContentType.JSON)
                                    .headers(headers)
                                    .body(UpdateUserRequest.getBody()))
            );
            Thread.sleep(5000);
            //Dado que es la misma URL que se maneja para actualizar el usuario
            actor.attemptsTo(
                    Get.resource(ENPOINT_USER_ID)
                            .with(requestSpecification -> requestSpecification
                                    .relaxedHTTPSValidation()
                                    .contentType(ContentType.JSON)
                                    .headers(headers))
            );
            phone = SerenityRest.lastResponse().getBody().jsonPath().get("phone");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
