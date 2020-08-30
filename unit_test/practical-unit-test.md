# Developer's Test

- Concept of oop: client, worker and manager classes
- Types of developer test
  - Unit test
  - Integration test
  - End to end test
- SUT (System Under Test)
- DOC (Dependent on Component) - a collaborator, any entity that is required by SUT to fulfill its duties
 - Tools
   - Testing Framework: JUnit
     - Libraries: JUnitParams
   - Mock Library: Mockito, PowerMock, EasyMock
   - Matcher Libraries: FEST and Hamcrest
   - Code Coverage: Cobertura

> Following OO rules leads to easily testable code.

> Easy-to-write tests denote sound code.

> A skillful developer can turn the process of creating unit tests into a design activity.

- Types of collaboration with an SUT
  - direct inputs and outputs
  - indirect inputs and outputs

- Part of Unit testing
  - State testing
    - workers class are involved
    - unit tests with no collaborators
    - uses direct inputs and outputs
  - Interaction testing
    - manager class are involved
    - SUT needs collaborator
    - uses indirect inputs and outputs

# Writing Unit Test

## State testing

- SUT does not need any collaborator
- Parameterized tests
  - Use parameterized test if testing for multiple parameters
- Avoid copy-paste coding
- Avoid global variables
- Follow DRY principle when coding unit test
- There should be a clear separation between test logic (how the code is expected to work) and test data (what values are tested)
- It is not advisable to introduce logic (i.e. for loop) inside a test.
- Make test highly readable.
  - Money money = new Money(invalidAmount, VALID_CURRENCY);
- The term "test fixture" refers to the notion of a "well known and fixed environment in which tests are run so that results are repeatable"

## Interaction testing

- SUT which cooperates with collaborators

# Hints and Discussion

# Listen and Organize

# Make Them Better

# Reference:

- Practical Unit Testing by Tomek Kaczanowski