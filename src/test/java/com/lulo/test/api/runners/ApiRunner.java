package com.lulo.test.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features/",
        glue = "com.lulo.test.api.stepdefinitions"//,
        //tags = "@CreateUser"
)
public class ApiRunner {

}
