import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() throws Exception {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        when(feline.eatMeat()).thenReturn(food);
        assertEquals(food, cat.getFood());
    }

    @Test
    public void testEatMeat() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        when(feline.eatMeat()).thenReturn(food);
        assertEquals(food, feline.eatMeat());
    }

    @Test
    public void testGetFoodException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testEatMeatException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Exception exception = assertThrows(Exception.class, () -> feline.eatMeat());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
    }
