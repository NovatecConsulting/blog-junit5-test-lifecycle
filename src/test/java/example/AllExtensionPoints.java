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


public class AllExtensionPoints
    implements TestInstancePostProcessor, BeforeAllCallback, BeforeEachCallback, BeforeTestExecutionCallback,
    AfterTestExecutionCallback, AfterEachCallback, AfterAllCallback {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        log("TestInstancePostProcessor");
    }

    @Override
    public void beforeAll(ContainerExtensionContext context) {
        log("BeforeAllCallback");
    }

    @Override
    public void beforeEach(TestExtensionContext context) {
        log("BeforeEachCallback");
    }

    @Override
    public void beforeTestExecution(TestExtensionContext context) {
        log("BeforeTestExecutionCallback");
    }

    @Override
    public void afterTestExecution(TestExtensionContext context) {
        log("AfterTestExecutionCallback");
    }

    @Override
    public void afterEach(TestExtensionContext context) {
        log("AfterEachCallback");
    }

    @Override
    public void afterAll(ContainerExtensionContext context) {
        log("AfterAllCallback");
    }

    private void log(String msg) {
        System.out.println(msg);
    }

}
