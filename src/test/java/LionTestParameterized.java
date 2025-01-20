import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionTestParameterized extends LionTest {

    public LionTestParameterized() {}

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {5, 5},
                {1, 1},
                {10, 10}
        };
    }

    @Parameterized.Parameter(0)
    public int kittensCount;

    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Test
    public void testGetKittensWithParameter() throws Exception {
        when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals(expectedKittensCount, lion.getKittens());
    }
}