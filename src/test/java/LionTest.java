import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    @Mock
    protected Feline feline;

    protected Lion lion;

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

    @Test(expected = Exception.class)
    public void testDoesHaveManeExceptionForInvalidSex() throws Exception {
            new Lion("Львенок", feline);
    }
}