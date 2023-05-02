package com.lulo.test.api.dummyapi.task.delete;

import com.lulo.test.api.dummyapi.Utilidades.Headers;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.HashMap;

import static com.lulo.test.api.dummyapi.constants.Constants.ENPOINT_USER_ID;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {

    HashMap<String, Object> headers = new HashMap<>();
    Headers header;


    public DeleteUserTask(){
        header=new Headers();
        headers=header.getHeaders();
    }



    public static Performable fromPage(){
        return instrumented(DeleteUserTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(ENPOINT_USER_ID)
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .headers(headers))
        );
    }
}
