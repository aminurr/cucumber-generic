Feature: Calculator Subtraction

  Notes:
  - The calculator is only required to support integer subtraction at this time

#====================================================================

  Scenario: Subtracting two positive numbers

    Given Invoke Function substract:
      | Operand 1 | Operand 2 |
      | 3         | 5         |

    Then I expect the result -2


#====================================================================

  Scenario: Subtracting one positive number and zero

    Given Invoke Function substract:
      | Operand 1 | Operand 2 |
      | 3         | 0         |

    Then I expect the result 3


#====================================================================

  Scenario: Subtracting zero and zero

    Given Invoke Function substract:
      | Operand 1 | Operand 2 |
      | 0         | 0         |

    Then I expect the result 0
