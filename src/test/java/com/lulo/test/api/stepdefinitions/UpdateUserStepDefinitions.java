package com.lulo.test.api.stepdefinitions;

import com.lulo.test.api.dummyapi.task.put.PutUpdateUserTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UpdateUserStepDefinitions {

    @Steps
    GetUserStepDefinitions getUserStepDefinitions;

    @Given("deseo actualizar usuarios por medio de la API")
    public void deseo_actualizar_usuarios_por_medio_de_la_api() {
        GetUserStepDefinitions.URL = "https://dummyapi.io/data/";
    }
    @When("ejecute la peticion y visualice el usuario actualizado")
    public void ejecute_la_peticion_y_visualice_el_usuario_actualizado() {
        getUserStepDefinitions.ejecute_la_peticion_y_visualice_los_usuarios_registrados();
        GetUserStepDefinitions.usuario = Actor.named("Usuario")
                .whoCan(CallAnApi.at(GetUserStepDefinitions.URL));
        GetUserStepDefinitions.usuario.attemptsTo(PutUpdateUserTask.fromPage());

    }
    @Then("debe corresponder la informacion al usuario actualizada")
    public void debe_corresponder_la_informacion_al_usuario_actualizada() {
        Assert.assertEquals(SerenityRest.lastResponse().getBody().jsonPath().get("phone"), PutUpdateUserTask.phone);
    }
}
