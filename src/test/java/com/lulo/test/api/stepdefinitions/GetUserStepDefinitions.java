package com.lulo.test.api.stepdefinitions;

import com.lulo.test.api.dummyapi.task.get.GetUserTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetUserStepDefinitions {

    public static String URL;
    public static Actor usuario;
     int status;

    @Given("deseo obtener los usuarios registrados en la API")
    public void deseo_obtener_los_usuarios_registrados_en_la_api() {
        URL= "https://dummyapi.io/data/";

    }

    @When("ejecute la peticion y visualice los usuarios registrados")
    public void ejecute_la_peticion_y_visualice_los_usuarios_registrados() {
        usuario = Actor.named("Usuario")
                .whoCan(CallAnApi.at(URL));
        usuario.attemptsTo(GetUserTask.fromPage());
    }

    @Then("se obtiene el codigo de respuesta {int}")
    public void se_obtiene_el_codigo_de_respuesta(int codigo) {
         if(SerenityRest.lastResponse().statusCode()==codigo){
            status = 1;
         }
         else {
             status = 0;
         }
         Assert.assertEquals("Codigo: ", codigo,SerenityRest.lastResponse().statusCode());
    }
}
