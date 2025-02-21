package buoi5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionTest {
    public int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    @Test
    void testSumFunction() {
        Assertions.assertEquals(15, sum(5)); // 1+2+3+4+5 = 15
        Assertions.assertEquals(1, sum(1));
        Assertions.assertEquals(55, sum(10));
    }
}
