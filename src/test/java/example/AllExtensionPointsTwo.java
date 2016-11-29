package example;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;


public class AllExtensionPointsTwo
    implements TestInstancePostProcessor, BeforeAllCallback, BeforeEachCallback, BeforeTestExecutionCallback,
    AfterTestExecutionCallback, AfterEachCallback, AfterAllCallback {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        log("TestInstancePostProcessor #2");
    }

    @Override
    public void beforeAll(ContainerExtensionContext context) {
        log("BeforeAllCallback #2");
    }

    @Override
    public void beforeEach(TestExtensionContext context) {
        log("BeforeEachCallback #2");
    }

    @Override
    public void beforeTestExecution(TestExtensionContext context) {
        log("BeforeTestExecutionCallback #2");
    }

    @Override
    public void afterTestExecution(TestExtensionContext context) {
        log("AfterTestExecutionCallback #2");
    }

    @Override
    public void afterEach(TestExtensionContext context) {
        log("AfterEachCallback #2");
    }

    @Override
    public void afterAll(ContainerExtensionContext context) {
        log("AfterAllCallback #2");
    }

    private void log(String msg) {
        System.out.println(msg);
    }

}
