import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTestParameterized {

        @Mock
        private Feline feline;

        private Lion lion;

        @Before
        public void init () throws Exception {
            MockitoAnnotations.initMocks(this);
            lion = new Lion("Самец", feline);
        }

        @Parameterized.Parameters
        public static Object[][] data () {
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
        public void testGetKittensWithParameter () throws Exception {
            when(feline.getKittens()).thenReturn(kittensCount);
            assertEquals(expectedKittensCount, lion.getKittens());
        }
    }