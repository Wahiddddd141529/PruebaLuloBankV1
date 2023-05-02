package com.lulo.test.api.stepdefinitions;

import com.lulo.test.api.dummyapi.task.post.PostCreateUserTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import javax.swing.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateUserStepDefinitions {


    @Given("deseo crear usuarios por medio de la API")
    public void deseo_crear_usuarios_por_medio_de_la_api() {
        GetUserStepDefinitions.URL = "https://dummyapi.io/data/";
    }

    @When("ejecute la peticion y visualice el usuario creado")
    public void ejecute_la_peticion_y_visualice_el_usuario_creado() {
        GetUserStepDefinitions.usuario = Actor.named("Usuario")
                .whoCan(CallAnApi.at(GetUserStepDefinitions.URL));
        GetUserStepDefinitions.usuario.attemptsTo(PostCreateUserTask.fromPage());
    }

    @Then("debe corresponder la informacion al usuario creado")
    public void debe_corresponder_la_informacion_al_usuario_creado() {
        if(SerenityRest.lastResponse().getBody().jsonPath().get("firstName").equals("Julian-V15")){
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero =new FileWriter("Usuario-Creado/user.txt");
                pw = new PrintWriter(fichero);
                for (int i = 0; i <=1; i++){
                    pw.println(SerenityRest.lastResponse().getBody().jsonPath().get("firstName").toString());
                }
                fichero.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        Path rutaApoyo = Paths.get("");
        String directoryName = rutaApoyo.toAbsolutePath().toString();
        JOptionPane mensajeArchivo = new JOptionPane("Por favor valide el archivo user.txt en la siguiente ruta " + directoryName + "\\Usuario-Creado\\user.txt \n" +
                "en 10 segundos el popup se cerrara automaticamente", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = mensajeArchivo.createDialog("Mensaje");
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Timer timer = new Timer(10000, e -> {
            dialog.dispose();
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }
}
