import animals.Cat;
import animals.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setCat() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        String expectedEat = "Кузнечики";
        Mockito.when(feline.eatMeat()).thenReturn(List.of(expectedEat));
        List<String> actualEat = cat.getFood();
        assertEquals(List.of(expectedEat), actualEat);
    }
}
