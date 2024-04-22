import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private Burger burger;
    private final String nameBun;
    private final float priceBun;
    private final IngredientType type;
    private final String nameIngredient;
    private final float priceIngredient;
    private final float expected;

    public BurgerPriceTest(String nameBun, float priceBun, IngredientType type, String nameIngredient, float priceIngredient, float expected) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.type = type;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Ржаная", 100, IngredientType.SAUCE, "тар-тар", 200, 400},
                {"Волшебная", 200, IngredientType.FILLING, "котлета", 300, 700}
        };
    }


    @Before
    public void setUp() {
        this.burger = new Burger();
        Bun bun = new Bun(nameBun, priceBun);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getPriceTest() {
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }
}
