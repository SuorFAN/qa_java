import animals.Feline;
import animals.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    private Feline feline;
    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(42);
        Lion lion = new Lion("Самец", feline);
        int result = lion.getKittens();
        assertEquals(42, result);
    }
    @Test
    public void testDoesHaveMane() {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
        lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Икра", "Сало"));
        Lion lion = new Lion("Самец", feline);
        List<String> result = lion.getFood();
        assertEquals(Arrays.asList("Икра", "Сало"), result);
    }
    @Test
    public void errorGender() {
        assertThrows(IllegalArgumentException.class, () -> new Lion("Оно", feline));
    }

}

