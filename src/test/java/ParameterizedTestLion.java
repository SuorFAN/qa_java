import animals.Feline;
import animals.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestLion {

    private final String sex;
    private final Feline feline;
    private final boolean isHaveMane;


    public ParameterizedTestLion(String sex, Feline feline, boolean isHaveMane) {
        this.sex = sex;
        this.feline = feline;
        this.isHaveMane = isHaveMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Feline feline = new Feline();
        return Arrays.asList(new Object[][]{
                {"Самец",feline, true},
                {"Самка",feline, false}
        });
    }

    @Test
    public void testDoesHaveMane() {
        Lion lion = new Lion(sex, feline);
        assertEquals(isHaveMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
            Lion lion = new Lion(sex, feline);
            List<String> result = lion.getFood();
            List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
            assertEquals(expectedFood, result);
        }
    }
