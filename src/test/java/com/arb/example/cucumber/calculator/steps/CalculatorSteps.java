package com.arb.example.cucumber.calculator.steps;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.arb.example.cucumber.calculator.SimpleCalculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatorSteps {

    int result;

    SimpleCalculator simpleCalculator = new SimpleCalculator();

    //To make sure input is validated as per methodName regex
    //@ParameterType(".*")
    @ParameterType("[a-zA-Z]\\w*")
    public String method(String methodName) {
        return methodName;
    }


    @Given("Invoke Function {method}:")
    public void delegatorFunction(String methodName, DataTable calculatorInputDataTable) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //reflection for now
        //use factory method, enum whatever to call the method
        //if using reflection cache the method with methodName as key in local map
        // for performance.
        Method instanceMethod
                = CalculatorSteps.class.getMethod(methodName, DataTable.class);
        instanceMethod.invoke(this, calculatorInputDataTable);

    }

    public void add(DataTable calculatorInputDataTable) {
        List<Map<String, String>> rows = calculatorInputDataTable.asMaps();
        for (Map<String, String> row : rows) {
            int operand1 = Integer.parseInt(row.get("Operand 1"));
            int operand2 = Integer.parseInt(row.get("Operand 2"));
            System.out.println("Add called...with params " + operand1 + ", " + operand2);
            result = simpleCalculator.doAddition(operand1, operand2);
        }
    }

    public void substract(DataTable calculatorInputDataTable) {
        List<Map<String, String>> rows = calculatorInputDataTable.asMaps();
        for (Map<String, String> row : rows) {
            int operand1 = Integer.parseInt(row.get("Operand 1"));
            int operand2 = Integer.parseInt(row.get("Operand 2"));
            System.out.println("sunstract called...with params " + operand1 + ", " + operand2);
            result = simpleCalculator.doSubtraction(operand1, operand2);
        }
    }

    @Then("I expect the result {double}")
    public void i_expect_the_result(Double expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(expectedResult == result);
    }

}
