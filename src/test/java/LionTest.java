import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, lion.getFood());
    }

    @Test
    public void testDoesHaveManeTrueForSamets() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFalseForSamka() throws Exception {
        lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeExceptionForInvalidSex() {
        try {
            new Lion("Львенок", feline);
            fail("Нет ожидаемого исключения");
        } catch (Exception e) {
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 5},
                {1, 1},
                {10, 10}
        });
    }

    private int kittensCount;
    private int expectedKittensCount;

    public LionTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void testGetKittensWithParameter() throws Exception {
        when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals(expectedKittensCount, lion.getKittens());
    }
}