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
        String expectedFood = "Сало";
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of(expectedFood));
        List<String> actualFood = feline.eatMeat();
        assertEquals(List.of(expectedFood), actualFood);
    }
    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
    @Test
    public void testGetKittens() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }
    @Test
    public void testGetKittensCount() {
        int expectedKittens = 7;
        int actualKittens = feline.getKittens(7);
        assertEquals(expectedKittens, actualKittens);
    }
}
