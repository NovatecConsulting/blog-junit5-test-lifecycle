package example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(AllExtensionPoints.class)
public class TestsWithExtensionsOnClass {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach()");
    }

    @Test
    void testOne() {
        System.out.println("testOne()");
    }

    @Test
    void testTwo() {
        System.out.println("testTwo()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
    }

}
