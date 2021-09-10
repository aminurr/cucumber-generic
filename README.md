Simple cucucmber example to inject generic methods in test steps without annotating them.

clone and run `mvn test`

Add new methods in `com.arb.example.cucumber.calculator.steps.CalculatorSteps` e.g `divide` and without annotation, user can write feature like:

```
Scenario: Dividing 4 and 2
  Given Invoke Function divide:
    | Operand 1 | Operand 2 |
    | 4         | 2         |

  Then I expect the result 2
```

`