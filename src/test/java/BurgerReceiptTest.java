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
public class BurgerReceiptTest {
    private Burger burger;
    private final String nameBun;
    private final float priceBun;
    private final IngredientType type;
    private final String nameIngredient;
    private final float priceIngredient;
    private final String expected;

    public BurgerReceiptTest(String nameBun, float priceBun, IngredientType type, String nameIngredient, float priceIngredient, String expected) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.type = type;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {"Ржаная", 100, IngredientType.SAUCE, "тар-тар", 200, String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "Ржаная", IngredientType.SAUCE.toString().toLowerCase(), "тар-тар", "Ржаная", 400.00000)},
                {"Волшебная", 200, IngredientType.FILLING, "котлета", 300, String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "Волшебная", IngredientType.FILLING.toString().toLowerCase(), "котлета", "Волшебная", 700.00000)}
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
    public void getReceiptTest() {
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
