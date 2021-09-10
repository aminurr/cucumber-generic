Feature: Calculator Addition

Notes:
- The calculator is only required to support integer addition at this time

#====================================================================

Scenario: Adding two positive numbers

Given Invoke Function add:
| Operand 1 | Operand 2 |
| 3         | 5         |

Then I expect the result 8


