import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> result = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void testGetFamily() {
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittens() {
        int result = feline.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testGetKittensWithCount() {
        int result = feline.getKittens(2);
        assertEquals(2, result);
    }
    }


