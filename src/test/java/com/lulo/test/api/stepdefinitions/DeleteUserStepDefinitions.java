package com.lulo.test.api.stepdefinitions;

import com.lulo.test.api.dummyapi.task.delete.DeleteUserTask;
import com.lulo.test.api.dummyapi.task.get.GetUserTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import com.lulo.test.api.stepdefinitions.GetUserStepDefinitions;

public class DeleteUserStepDefinitions {

    String id;
    int status;
    @Steps
    GetUserStepDefinitions getUserStepDefinitions;

    @Given("deseo elimnar un usuario por medio de la api")
    public void deseo_elimnar_un_usuario_por_medio_de_la_api() {
        GetUserStepDefinitions.URL = "https://dummyapi.io/data/";

    }
    @When("ejecute la peticion y elimine el usuario por medio del id")
    public void ejecute_la_peticion_y_elimine_el_usuario_por_medio_del_id() {
        getUserStepDefinitions.ejecute_la_peticion_y_visualice_los_usuarios_registrados();
                GetUserStepDefinitions.usuario = Actor.named("Usuario")
                .whoCan(CallAnApi.at(GetUserStepDefinitions.URL));
        GetUserStepDefinitions.usuario.attemptsTo(DeleteUserTask.fromPage());

    }
    @Then("se debe obtener el codigo de respuesta {int}")
    public void se_debe_obtener_el_codigo_de_respuesta(int codigo) {
        if(SerenityRest.lastResponse().statusCode()==codigo){
            status = 1;
        }
        else {
            status = 0;
        }
        Assert.assertEquals("Codigo: ", codigo,SerenityRest.lastResponse().statusCode());
        Assert.assertEquals(SerenityRest.lastResponse().getBody().jsonPath().get("id").toString(), GetUserTask.id);
    }

}
