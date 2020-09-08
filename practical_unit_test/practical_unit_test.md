# Practical Unit Test

## Part 1 Developer's Test

### An Object Oriented System

- Concept of oop: client, worker and manager classes

### Types of developer's test

- Parts of the system affected by each type of test
  - System Under Test (SUT) - the part of the system being tested
  - Dependent on Component (DOC) (collaborator) - any entity that is required by SUT to fulfill its duties

    | Unit Test | Integration Test | End to end Test|
    |--|--|--|
    | developer point of view |developer point of view |client point of view; put the system as a whole to test, mimicking the way the user would use it |
    |scope includes a single SUT| scope includes SUT and collaborator|scope includes client|
    |extend across one layer (i.e. Service)| extend across few layers (i.e. Dao, Service)| extend across all layers (UI, Service, Dao)|
    |collaborators are replaced by test doubles|collaborators not touched by integration tests are replaced by test doubles|Test doubles are rarely used|
    |SUTs and collaborators are simply classes|act at the level of modules or layers|whole application being tested (the application is the SUT; other application is the collaborators)|

### Verification and Design

- Verifiers: make sure the code does what it should do; able to sacrifice OO rules to make it work
- Designers: believe that following OO rules is the most important thing, and that it leads to easily testable code; easy-to-write tests denote sound code.

### Tools

- The point is to grasp the ‘why’ and the ‘what for’, so that you know when to use (or not use) them.
- The importance of the ideas embodied in certain tools. If you get a good grasp of those ideas, you will be able to follow them with almost any tool. If you concentrate on tools, you will soon need to relearn all that was dear to you. Ideas are everlasting, but tools are there only for a short period of time.
  - Testing Framework: **JUnit**
  - Mock Library: **Mockito**
  - Fluent Assertions: **AssertJ**
  - Other Libraries:
    - Libraries: JUnitParams
    - Mock Library: Mockito, PowerMock, EasyMock
    - Matcher Libraries: FEST and Hamcrest
    - Code Coverage: Cobertura

### Unit Test

- When writing unit tests it is important to test a single class and nothing more. Concentrate on the logic of your class. Once you are sure your code works fine, then test its integration with other components.
- A skilful developer can turn the process of creating unit tests into a design activity

### Types of interaction in unit tests

- direct input, direct output, indirect input, indirect output

### Parts of Unit Test

- **State testing**  *SUT does not need any collaborator*
  - workers class are involved; unit tests with no collaborators
  - to make sure that the computations done, and the values returned, are correct
  - uses direct inputs and outputs
  - Testing of direct outputs is also called "state verification"
- **Interaction testing** *SUT which cooperates with collaborators*
  - manager class are involved; SUT needs collaborator
  - concentrate on how messages are passed between collaborators
  - uses indirect inputs and outputs
  - testing of indirect outputs is called "behaviour verification"

## Part 2 Writing Unit Test

### Unit Tests With No Collaborators

- Assertions, Assertions chaining
- Failing Test
- Parameterized tests
  - Use parameterized test if testing for multiple parameters
- When writing unit test:
  - Avoid copy-paste coding
  - Avoid global variables
  - Follow DRY principle when coding unit test
  - There should be a clear separation between test logic (how the code is expected to work) and test data (what values are tested)
  - It is not advisable to introduce logic (i.e. for loop) inside a test.
  - Make test highly readable: `Money money = new Money(invalidAmount, VALID_CURRENCY);`

### Test Fixture

- The term "test fixture" refers to the notion of a "well known and fixed environment in which tests are run so that results are repeatable"
- The `@BeforeEach` annotation makes JUnit execute this method before each test method is executed.
- `@AfterEach` is executed after each test method
- `@BeforeAll` and `@AfterAll` follow the logic of @BeforeEach and @AfterEach, but on the class level

### Phases of a Unit Test

- **Arrange / Act / Assert**
  - Arrange - it creates an object to be tested (the SUT) along with other required objects (the SUT’s collaborators)
  - Act - it executes the SUT’s methods
  - Assert - it verifies the results
- all assertions within a single test method verify properties of a single object: the SUT. Asserting on many objects within a single test method is considered bad practice, and should be avoided!

#### Summary

- what assertions AssertJ provides
- how to use parameterized tests
- how to verify expected exceptions
- how to use annotations for test fixture management

### Test Driven Development

- When to write tests
  1. Test Last (AKA Code First) Development
      - tests are written after the production code has been finished.
      - *disadvantage*
        - developer concentrates on testing the implementation instead of testing the interface (behaviour) of the SUT.
        - can lead to tests which are tightly coupled to the implementation (and as such will need to be rewritten every time it changes)
  2. Test First Development (called Test Driven Development TDD)
      - writing the tests before the actual code makes developers think about the behaviour of the tested object as opposed to its implementation (which does not exist at this point).
  3. Always after a Bug is Found
      - The first thing you should do after a bug has been found is to restrain your natural urge to fix it right away.
      - The test should expose the bug, Then fix the code so the test passes.

### TDD Rhythm

1. Write a test that fails (RED).  
2. Make the code work (GREEN).  
3. Eliminate redundancy (REFACTOR).

- never write code without a failing test!

#### RED - Write a Test that Fails

- Think about some functionality that should be implemented and write it down in the form of a test.
- This is what TDD is really all about: the design of an API.
- Concentrate on what the client (the test code) really needs. And write tests which test exactly this, and nothing more.
  - No more unnecessary methods, written because "they might just possibly be useful for someone someday", no more auto-generated getters/setters, when an immutable class is much more appropriate.
  - Readable Assertion Message

#### GREEN - Write the Simplest Thing that Works

- write the smallest amount of code that will satisfy the test.
- "only enough to pass the test" coding
- Prevent **YAGNI** code (You aren't gonna need it)

#### REFACTOR - Improve the Code

- Refactoring is a way of restructuring the code without changing its functionality.
- OO Principles: **DRY** (Don't Repeat Yourself), **KISS** (Keep It Simple Stupid), **SRP** (Single Responsibility Pattern)
- Once the test passes you can make some changes to your code. The safety net of tests gives you the confidence that you will not break anything as long as you "keep the bar green".
- the refactoring phase is also a good moment to add some documentation
- Refactor the tests

### Benefits of TDD

- 100% of the code we created is covered with unit tests, which allowed us to refactor the algorithm without the fear of breaking anything
- there are no superfluous parts of the code that have been written just because they "could possibly be useful" or "will surely be required one day" (YAGNI) - we created only what was requested by clients (in our case, our clients were the tests)
- writing the smallest amount of code to make the test pass led us to simple solutions (KISS)
- thanks to the refactoring phase, the code is clean and readable (DRY) - both the production code and the tests
- it is easy to go back to coding, even after interruptions; all you have to do is take the next test from the list and start the next cycle

- TDD is based on a set of very simple rules: first write a test, then see it fail, make it pass, refactor, check that it is still green, and then… repeat the cycle.

### Interaction Testing: Mocks, Stubs, and Dummies

- Rule of Thumb: Write an interactions test only if some of the SUT’s features cannot be tested using state testing.
- **Test doubles** are used to replace collaborators of the SUT.
  - gain full control over the environment in which the SUT is running,
  - move beyond state testing and verify interactions between the SUT and its collaborators.
- Types: Mock and Stub
  - Mocks are used to verify indirect outputs.
  - Stubs will help us to deal with indirect inputs.
- Other types:
  - *dummy object, test stub*
    - Dummies and stubs are used to prepare the environment for testing. They are not used for verification.
  - *mock, test spy*
    - The purpose of test spies and mocks is to verify the correctness of the communication between the SUT and its collaborators.
  - fake
    - works almost as well as a real collaborator, but is somehow simpler and/or weaker i.e. in-memory database
    - In tests, a fake plays a similar role to a dummy and a stub: it is a part of the environment (test fixture), not an object of verification.

#### Creating test doubles

- `Mockito.mock(TemplateEngine.class)`
- mocks == test doubles
- "X was mocked" == "a test double of type X was created"

#### Stubbing

- The point of having a test double is to tell it what it should do. We need to instruct our test double of templateEngine type that it should return some message content (msgContent).
- `when(templateEngine.prepareMessage(any(), any())).thenReturn("I am")`
- we turned our undefined test double into a stub that will feed our SUT with indirect input when requested.

#### Verification

- `verify(mailServer).send("em@il.com", "I am")`
- Using the verify() method to check if the right method was called in the right way. By using this method we verify indirect outputs of our SUT turning our mailSender test double into a mock.

### TDD with Test Doubles

- `code to an interface, and not to an implementation`
- Phone class with constructor enhanced example
- **State testing:** concentrates only on "what" the results of actions amount to.
- **Interaction testing:** the focus changes from "what" to "how".

## Part 3 Hints and Discussion

### Beyond Assertions

- default assertions provided by AssertJ
- custom matchers
- conditions

#### Values to check

- You should select arguments to check that belong to these three groups:
  - expected values (AKA happy path)
  - boundary values
  - strange or unexpected values (AKA validity or domain)
- *What you are going to be paid for is to build this particular application – not to prepare your code so you can build any application with it.*
- pairwise testing || quickcheck testing

#### The Next Test To Write

- The Low-Hanging Fruit.*"Start with something really simple. Implement an obvious test case."*
  - Writing something, even something trivial or of only minimal importance, might be helpful to overcome this sort of "writer’s block".
- The Most Informative One.
- First The Typical Case, Then Corner Cases.
- Listen To Your Experience.

#### Disable test

- `@Disabled`, `@DisabledOnOs`, `@DisabledOnJre`
- Assumptions class

#### Expected and Mockito Exceptions

#### Stubbing void methods

- `doThrow()`, `doNothing()`, `doAnswer()`

#### Mockito Matchers vs Hamcrest Matchers

- Mockito offers a variety of predefined matchers which can be used for verification or stubbing.
- `import static org.mockito.Mockito.argThat;`
- `import static org.mockito.hamcrest.MockitoHamcrest.argThat;`
- One thing to remember is that if you are using argument matchers, all arguments have to be provided by matchers.

#### Asynchronous Code

- *"mock only types that you own"*: that since we don’t own the ExecutorService we should not mock it.
- Approach #1: wait (preferably by constant polling) for the desired thing to happen.
- Approach #2: reduce the asynchronous code to its synchronous counterpart and then solve it using a standard approach.

#### Time

- create a new interface of TimeProvider that would encapsulate all operations related to time
- redesign Hello class a little bit, so it uses this TimeProvider instead of using the Calendar class directly.
- dependency injection and constructor injection

#### Collections

#### Parameterized Tests

#### Converters

### Point of Controversy

#### Access Modifiers

#### Random Object Properties

- Java Faker; Apache Commons Lang - RandomStringUtils; Property-based testing frameworks - jqwik, junit-quickcheck

#### Setup Method

  ```java
  public class SetUpTest {

    private Collaborator collaborator;
    private OtherCollaborator otherCollaborator;
    private SUT sut;

    @BeforeEach
    void setUp() { 
      collaborator = mock(Collaborator.class);
      otherCollaborator = mock(OtherCollaborator.class);

      sut = new SUT(collaborator, otherCollaborator);
    }
 
    @Test
   void testA() {
     // assertions
   }

    @Test
   void testB() {
     sut.someConfigurationMethod();
     // assertions
   }
  ```

#### Assertions per Test Method

- OAPTM One Assertion Per Test Method
- each test method should concentrate on a single feature of the SUT.
- Soft assertions - each of the assertions within the code block will be executed no matter the failures of previously executed ones; useful for integration tests

#### Private Method Testing

- chicken and egg dilemma
- Use reflection or weaken access modifier

#### Lambda Expression

- What we can do is extract the lambda and use method reference instead. The testing of this method should be a simpler task then, because we don’t need to deal with stream pipelines.

#### New Operator

- collaborators of the SUT could be replaced easily: they are "injected" into the SUT - as constructor parameters, method parameters or using setters.
- Conflict if injection is not used:
  
    ```java
    MyCollaborator collaborator = new MyCollaborator()
    MyCollaborator collaborator = MyFactory.getCollaborator(…))
    MyCollaborator collaborator = LookupService.findCollaborator(…))
  ```

- Solution:
  - use a tool that allows us to test tightly coupled code like *new operator*, *static method calls*, *untestable language constructs*
    - Powermock
  - introduce some changes to the original code and use tool (i.e. Mockito). Mockito works perfectly with well-written, loosely coupled code, but refuses to test code that is tightly-coupled.
    - redesign and inject
    - subclass and override
    - partial mocking (spy)

#### Capturing Arguments to Collaborators

- PersonalInformationManager
- ArgumentCaptor || ArgumentCatcher

#### Files and Databases

## Part 4 Listen And Organize

### Getting Feedback

- assertThat(clientA).isEqualToComparingFieldByField(clientB);
- assertThat().as("error_message_here").isEqualTo()
- verify().description("error_message_here").method()
- `To conclude, first you should "use the right tool for the job", and second, in the presence of such a wealth of freely available options, why bother with implementing your own solution?`
- debugging session:
  - setting breakpoints
  - getting information on the values of variables
  - various types of moving forward (step into, step over, etc.)

### Organization of Tests

- Package
- Names
  - Test Class Names: *MyClassTest, MyClassFeatureTest, MyClassNullValuesTest*
    - The necessity of splitting up a test class might by indicative that what you should really be splitting up is the class being tested itself! If it cannot be tested with one test class, maybe it is too big - maybe it has too much responsibility? If so, then fix this problem, and the test class will automatically shrink to an appropriate length.
  - Test Method Names: should..()
  - Test Double Variables Names: collabSpy
- Comments
- BDD (Behaviour-Driven Development): Given When Then
  - BDD is more applicable to higher-level tests (i.e. end-to-end tests) than unit testing
  - Given some initial context (the givens), When an event occurs, Then ensure some outcomes.
- Mockito Boilerplate Code
  - OneLinerStubs
  - Annotations
    - `@ExtendWith(MockitoExtension.class)` - This will result in the creation of test doubles for all fields marked with an @Mock annotation.
    - `@Mock` - The collaborator, which will be replaced by a test double, is marked with an @Mock annotation. No Mockito.mock(…) required!
    - `@InjectMocks` - We asked Mockito to inject our collaborator into sut using @InjectMocks annotation. No need to write sut.setCollaborator(collaborator) anymore!
- Complex Objects
  - Object Mother Pattern
  - Test Data Builder Pattern

## Part 5 Make Them Better

### Maintainable Tests

- Test Behaviour, not Methods
  - Follow the whisper of your test methods: "Please keep us small & focused on single behavior".
  - when writing tests, we should think about the SUT in terms of its responsibilities - in terms of the contract it has with its client.
  - SUT should fulfill the requirements for which it was designed.
  - The requirements know nothing about the actual implementation, and neither should our tests.
  - "one test method per production code method"
  - Good test method names include information about the scenario they verify.
  - Forget about implementation. Think about requirements.
  - methods testing vs class responsibilities testing
- Complexity leads to bugs
  - Do not put any complexity into your tests! No if structure, no switch statements, no decision making.
- Follow the rules or suffer
  - "Tell, Don’t Ask!" principle
  - Procedural code gets information, then makes decisions. Object-oriented code tells objects to do things. (object should ask others to do whatever it wants, rather than doing the job based on the data they are willing to provide.)
  - bad code makes it hard to write tests.
- Rewriting Tests when the Code Changes
  - Avoid Overspecified Tests: a test is overspecified if it verifies some aspects which are irrelevant to the scenario being tested.
  - we should write tests which verify the expected outcome of systems behaviour, and not the behaviour itself. If possible, let us verify that the system works properly by analyzing returned values. Only when this is not possible should we resort to interactions testing.
- Things Too Simple To Break
- Summary:
  - Test behaviour, not implementation!
  - the Law of Demeter (principle of least knowledge)
  - the Tell, Don’t Ask! principle

### Test Quality

## Note

- static imports

  ```java
  import static org.assertj.core.api.Assertions.assertThat;
  import static org.mockito.Mockito.mock;
  ```
  
- Hamcrest vs AssertJ
  
  ```java
  assertThat(a, equalTo(b)); //Hamcrest

  assertThat([value], [matcher statement]); // JUnit4 and Matcher

  assertThat(a).isEqualTo(b); //AssertJ
  ```

- Assertions: JUnit5 vs AssertJ

  ```java
  import org.junit.jupiter.api.Assertions;
  import org.assertj.core.api.Assertions;
  ```

- Mockito Matchers: ArgumentMatcher vs HamcrestMatcher

  ```java
  import static org.mockito.Mockito.argThat;
  import static org.mockito.hamcrest.MockitoHamcrest.argThat;
  ```

## Reference

- Kaczanowski, Tomek. *Practical Unit Testing with JUnit and Mockito* . Kindle Edition.
- Freeman, *Growing Object-Oriented Software, Guided by Tests*
- [Dzone: Hamcrest vs. AssertJ](https://dzone.com/articles/hamcrest-vs-assertj-assertion-frameworks-which-one)
- [Migrating from JUnit 5 assertions to AssertJ](http://testinglikeaboss.com/tips-tricks/migrating-from-junit-5-assertions-to-assertj/)
- [Matchers and assertThat](https://github.com/junit-team/junit4/wiki/Matchers-and-assertthat)
- [JUnit 5 Docs Parameterized Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
- [Using Mockito without static imports with Java 8](https://solidsoft.wordpress.com/2015/12/01/using-mockito-without-static-imports-with-java-8/)
