import animals.Cat;
import animals.Feline;
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

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Кузнечики"));
        List<String> result = cat.getFood();
        assertEquals(List.of("Кузнечики"), result);
    }
}
