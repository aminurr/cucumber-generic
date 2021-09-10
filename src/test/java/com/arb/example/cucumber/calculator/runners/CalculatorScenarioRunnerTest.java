package com.arb.example.cucumber.calculator.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.arb.example.cucumber.calculator.steps", strict = true)
public class CalculatorScenarioRunnerTest {
}