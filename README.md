# Better Assertions

A quick demo application to show various assertion (anti-)patterns, and how to improve those with OpenRewrite recipes.

### Bad examples

A bit of a rant on bad testing practices seen over the years.

0. [Code coverage tests](src/test/java/com/github/timtebeek/betterassertions/coverage/CoverageTest.java)
0. [Plain `assert`](src/test/java/com/github/timtebeek/betterassertions/plain/PlainAssert.java) 
0. [AssertThrows catch early](src/test/java/com/github/timtebeek/betterassertions/junit5/AssertThrowsCatchTest.java)
0. [AssertEquals list size](src/test/java/com/github/timtebeek/betterassertions/junit5/AssertListSize.java)
0. [AssertTrue list contains](src/test/java/com/github/timtebeek/betterassertions/junit5/AssertListContains.java)
0. [Failure message argument order](src/test/java/com/github/timtebeek/betterassertions/junit5/ArgumentOrderTest.java)
0. [Try catch and fail](src/test/java/com/github/timtebeek/betterassertions/junit5/TryCatchFailTest.java)

### Dated examples

Beyond just bad practices, there are also just outdated practices.

0. [JUnit 3](src/test/java/com/github/timtebeek/betterassertions/junit3/JUnitThreeTest.java)
0. [JUnit 4](src/test/java/com/github/timtebeek/betterassertions/junit4/JUnitFourTest.java)
0. [Hamcrest](src/test/java/com/github/timtebeek/betterassertions/junit3/JUnitThreeTest.java)
0. [JUnit Jupiter](src/test/java/com/github/timtebeek/betterassertions/junit5/JUnitJupiterTest.java)
0. [AssertJ](src/test/java/com/github/timtebeek/betterassertions/assertj/AssertJTest.java)
0. [Outdated Java in tests](src/test/java/com/github/timtebeek/betterassertions/junit5/TextBlockTest.java)

### Automatic conversion

A quick command to improve the above tests by adopting AssertJ. 

```shell
mvn rewrite:run -Drewrite.activeRecipes=com.github.timtebeek.BetterAssertions
```

### Better examples

A few examples of my favorite features of AssertJ.

0. Chained assertions
0. [Custom AssertionProvider](src/test/java/com/github/timtebeek/betterassertions/assertj/AssertThatBookTest.java)
0. [Soft assertions](src/test/java/com/github/timtebeek/betterassertions/assertj/AssertSoftlyTest.java)
0. [Satisfies](src/test/java/com/github/timtebeek/betterassertions/assertj/SatisfiesTest.java)

### AssertJ's own examples
0. https://github.com/assertj/assertj-examples/
0. https://github.com/assertj/assertj-examples/commit/72c339f0f72fd4a6e903c25af2d3f093702f3e4c

### MockMvc examples

0. [MockMvc test with Hamcrest](src/test/java/com/github/timtebeek/betterassertions/mockmvc/BundleControllerOldTest.java)
0. [MockMvc test with AssertJ](src/test/java/com/github/timtebeek/betterassertions/mockmvc/BundleControllerNewTest.java)
0. [MockMvc test with bridge](src/test/java/com/github/timtebeek/betterassertions/mockmvc/BundleControllerBridgeTest.java)