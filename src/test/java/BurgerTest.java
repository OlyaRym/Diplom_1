import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
public class BurgerTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    private Burger burger = new Burger();
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    @Test
    public void setBuns() {
        burger.setBuns(new Bun("black bun", 100));
        System.out.println(burger);
    }
    @Test
    public void addIngredientTest(){  //Добавляющий ингредиент
        burger.addIngredient(ingredient1);
        int actual = burger.ingredients.size();
        int expected = 1;
        assertEquals(actual,expected);

    }
    @Test
    public void removeIngredientTest(){  //удалить ингридиент
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 0;
        assertEquals(actual,expected);
    }
    @Test
    public void moveIngredientTest(){  //переместить ингредиент
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Ingredient actual = burger.ingredients.get(1);
        Ingredient expected = ingredient1;
        assertEquals(actual,expected);
    }
    //    @Test  //тест работает, вынесла в отдельный класс для параметризации
//    public void getPriceTest() {
//        burger.addIngredient(ingredient1);
//        burger.addIngredient(ingredient2);
//        Mockito.when(bun.getPrice()).thenReturn(100F);
//        burger.setBuns(bun);
//        float actual = burger.getPrice();
//        float expected = 600;
//        assertEquals(actual,expected, 0.05);}
    @Test
    public void getReceiptTest(){
        burger.addIngredient(ingredient1); //добавили ингредиент 1
        burger.setBuns(bun); //булочка
        Mockito.when(bun.getName()).thenReturn("red"); //мокито для имени булки
        float priceActual = burger.getPrice(); // receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        String receiptActual = burger.getReceipt();  //receipt.append(String.format("%nPrice: %f%n", getPrice()));
        float priceExpected = 300;
        String receiptExpected = "red";
        assertThat(receiptActual,containsString(receiptExpected)); //матчер containsString содержит строку
        assertEquals(priceActual,priceExpected,0.05);
    }
}

