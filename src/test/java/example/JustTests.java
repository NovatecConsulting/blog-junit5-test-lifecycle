package example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JustTests {

    @BeforeAll
    static void beforeAll() {
        log("beforeAll()");
    }

    @BeforeEach
    void beforeEach() {
        log("beforeEach()");
    }

    @Test
    void testOne() {
        log("testOne()");
    }

    @Test
    void testTwo() {
        log("testTwo()");
    }

    @AfterEach
    void afterEach() {
        log("afterEach()");
    }

    @AfterAll
    static void afterAll() {
        log("afterAll()");
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

}
