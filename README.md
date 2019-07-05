# junit-displayname-generators

[![Build Status](https://travis-ci.org/spencerwi/junit-displayname-generators.svg?branch=master)](https://travis-ci.org/spencerwi/junit-displayname-generators)

[JUnit 5.4 and above support specifying a `@DisplayNameGenerator`](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator) to "rewrite" your test function names into more  
readable display names for output, like so:

```java
@DisplayNameGenerator(DisplayNameGenerator.ReplaceUnderscores.class)
class FooTest {
    @Test
    void some_test_that_checks_foo_behavior() {
        // ...
    } 
    // test will display as "some test that checks foo behavior"
}
```

The `ReplaceUnderscores` one demonstrated above ships with JUnit 5.4.

However, a more common practice in Java is to use camelCase (sometimes
combined with underscores) to denote word separators.

This repo is a small-footprint packaging of a couple of different `@DisplayNameGenerator` classes
that nicely format methods written with these more common practices.

## Included DisplayNameGenerators

`@DisplayNameGenerator(UnCamelCase.Methods.class)` will rewrite the test method names only, "uncamelizing" them (
so that `someTestThatChecksFooBehavior` becomes `"some Test That Checks Foo Behavior"`).

`@DisplayNameGenerator(UnCamelCase.All.class)` will rewrite the test method names *and* class names, "uncamelizing" them (
so that `someTestThatChecksFooBehavior` becomes `"some Test That Checks Foo Behavior"`).

`@DisplayNameGenerator(ReplaceUnderscoresAndUnCamelCase.Methods.class)` will rewrite the test method names only, 
"uncamelizing" them and replacing underscores with spaces (so that `testFoo_WhenUserIsNotFound_Throws` becomes `"test Foo When User Is Not Logged In Throws"`).

`@DisplayNameGenerator(ReplaceUnderscoresAndUnCamelCase.Methods.class)` will rewrite the test method names *and* class 
names, 
"uncamelizing" them and replacing underscores with spaces (so that `testFoo_WhenUserIsNotFound_Throws` becomes `"test Foo When User Is Not Logged In Throws"`).

### Installation

It's published in Maven Central! So all you have to do is add this to your Maven pomfile's dependency section (or the equivalent for your build tool):

```xml
<dependency>
    <groupId>com.spencerwi</groupId>
    <artifactId>junit-displayname-generators</artifactId>
    <version>1.0.0</version>
</dependency>
```
