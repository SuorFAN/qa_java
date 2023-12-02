import animals.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;
    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Сало"));
        List<String> result = feline.eatMeat();
        assertEquals(List.of("Сало"), result);
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
    public void testGetKittensCount() {
        int result = feline.getKittens(7);
        assertEquals(7, result);
    }
}
