package com.lulo.test.api.dummyapi.task.post;

import com.lulo.test.api.dummyapi.Utilidades.Headers;
import com.lulo.test.api.dummyapi.model.data.CreateUserRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;

import static com.lulo.test.api.dummyapi.constants.Constants.ENPOINT_CREATE_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreateUserTask implements Task {

    HashMap<String, Object> headers = new HashMap<>();
    Headers header;

    CreateUserRequest bodyRequestUser = new CreateUserRequest();

    public PostCreateUserTask(){
        header=new Headers();
        headers=header.getHeaders();
        bodyRequestUser.bodyRequest();
    }

    public static Performable fromPage(){
        return instrumented(PostCreateUserTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ENPOINT_CREATE_USER)
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .headers(headers)
                                .body(CreateUserRequest.getBody())
                        )
        );

    }

}
