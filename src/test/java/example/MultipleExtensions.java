package example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(AllExtensionPointsTwo.class)
@ExtendWith(AllExtensionPointsOne.class)
public class MultipleExtensions {

    @Test
    void test() {
        log("test()");
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

}
