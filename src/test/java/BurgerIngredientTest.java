import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {
    private Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;

    @Before
    public void setUp() {
        this.burger = new Burger();
        burger.addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        int index = burger.ingredients.indexOf(ingredient);
        burger.addIngredient(newIngredient);
        int newIndex = burger.ingredients.indexOf(newIngredient);
        burger.moveIngredient(index, newIndex);
        int indexForMovedElement = burger.ingredients.indexOf(ingredient);//Переместили первый ингредиент на место второго и запросили его новый индекс
        assertEquals(newIndex, indexForMovedElement);//проверяем, что индекс перемещенного элемента стал равен индексу второго элемента, на место которого его переместили
    }
}
