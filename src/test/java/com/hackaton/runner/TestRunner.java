package com.hackaton.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "(@Test) and not @skip",
        features = {"src/feature/"},
        glue = {"com.hachton.stepdefinition"},
        monochrome = true
)
public class TestRunner {


}
