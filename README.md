# JUnit 5 Test Lifecycle

When writing or using extensions in JUnit 5 you should know
exactly how and when they are invoked. Not knowing might
confuse you with unexpected behavior!

Let's start with a simple test class containing two tests
and all regular lifecycle methods:

```java
public class JustTests {

    @BeforeAll
    static void beforeAll() {log("beforeAll()");}

    @BeforeEach
    void beforeEach()       {log("beforeEach()");}

    @Test
    void testOne()          {log("testOne()");}

    @Test
    void testTwo()          {log("testTwo()");}

    @AfterEach
    void afterEach()        {log("afterEach()");}

    @AfterAll
    static void afterAll()  {log("afterAll()");}

}
```

Executing this class produces the following output:

```
beforeAll()
beforeEach()
testOne()
afterEach()
beforeEach()
testTwo()
afterEach()
afterAll()
```

This is the same basic lifecycle as it has been since JUnit 4
and will server as our baseline.

Now let's implement an extension class implementing all available
lifecycle extension points:

- TestInstancePostProcessor
- BeforeAllCallback
- BeforeEachCallback
- BeforeTestExecutionCallback
- AfterTestExecutionCallback
- AfterEachCallback
- AfterAllCallback

This extension follows the same principle as the test methods by logging
the extension point's name when executed. When we activate this extension
on our test class, we get the following output:

```
BeforeAllCallback
beforeAll()
TestInstancePostProcessor
BeforeEachCallback
beforeEach()
BeforeTestExecutionCallback
testOne()
AfterTestExecutionCallback
afterEach()
AfterEachCallback
TestInstancePostProcessor
BeforeEachCallback
beforeEach()
BeforeTestExecutionCallback
testTwo()
AfterTestExecutionCallback
afterEach()
AfterEachCallback
afterAll()
AfterAllCallback
```

This is exactly the behaviour I would expect.

It gets a little bit more interesting when we use our extension on a
single test method, instead of the whole class. When we do this, we
get the following output:

```
beforeAll()
BeforeEachCallback
beforeEach()
BeforeTestExecutionCallback
testOne()
AfterTestExecutionCallback
afterEach()
AfterEachCallback
beforeEach()
testTwo()
afterEach()
afterAll()
```

As you can see, the static `BeforeAllCallback` and `AfterAllCallback`
as well as the `TestInstancePostProcessor` extension points are no longer
executed. Since the extension is only used on a single test method, it
makes sense that the static callbacks are skipped. It makes less sense for the
instance post processor. As of JUnit `5.0.0-M2` none of this is hinted
at in the JavaDoc. I'm sure this will be remedied until the final release.

As a final example, let's clone our extension and change the output to
include #1 and #2 as an identification. This will demonstrate how the
order, in which extensions are declared, has a direct impact on when
they are invoked.

If we declare the extension like this:

```java
@ExtendWith(AllExtensionPointsOne.class)
@ExtendWith(AllExtensionPointsTwo.class)
public class MultipleExtensions {

    @Test
    void test() {log("test()");}

}
```

We get output like this:

```
BeforeAllCallback #1
BeforeAllCallback #2
TestInstancePostProcessor #1
TestInstancePostProcessor #2
BeforeEachCallback #1
BeforeEachCallback #2
BeforeTestExecutionCallback #1
BeforeTestExecutionCallback #2
test()
AfterTestExecutionCallback #2
AfterTestExecutionCallback #1
AfterEachCallback #2
AfterEachCallback #1
AfterAllCallback #2
AfterAllCallback #1
```

Notice how the order of execution correlates to the order of declaration?
If we were to switch the declaration order, we would get this:

```
BeforeAllCallback #2
BeforeAllCallback #1
TestInstancePostProcessor #2
TestInstancePostProcessor #1
BeforeEachCallback #2
BeforeEachCallback #1
BeforeTestExecutionCallback #2
BeforeTestExecutionCallback #1
test()
AfterTestExecutionCallback #1
AfterTestExecutionCallback #2
AfterEachCallback #1
AfterEachCallback #2
AfterAllCallback #1
AfterAllCallback #2
```

As always, you can find the code of these examples on
[GitHub](https://github.com/nt-ca-aqe/blog-junit5-test-lifecycle).
