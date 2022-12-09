import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class GetPriceTest {
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;
    private float priceTotal; //итоговая цена с которой сравниваю

    public GetPriceTest(Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, float priceTotal) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.priceTotal = priceTotal;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                {new Ingredient(IngredientType.FILLING, "cutlet", 200),new Ingredient(IngredientType.FILLING, "cheese", 50),new Ingredient(IngredientType.SAUCE, "sour cream", 50),400},
                {new Ingredient(IngredientType.FILLING, "cutlet chicken ",130),new Ingredient(IngredientType.FILLING, "cheese with mold", 300),new Ingredient(IngredientType.SAUCE, "hot sauce", 60),590},
                {new Ingredient(IngredientType.FILLING, "cutlet", 200),new Ingredient(IngredientType.FILLING, "sausage", 300),new Ingredient(IngredientType.SAUCE, "chili sauce", 300),900},
                {new Ingredient(IngredientType.FILLING, "cutlet chicken ",130),new Ingredient(IngredientType.SAUCE, "sour cream", 50),new Ingredient(IngredientType.SAUCE, "hot sauce", 60),340},
        };
    }
    @Before
    public void init() {  ////моки,т.к нельзы использовать два @RunWith
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    private Burger burger = new Burger();
    @Test
    public void getPriceTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Mockito.when(bun.getPrice()).thenReturn(50F); //стоимость bun.getPrice()=50 и * 2 = 100
        burger.setBuns(bun);
        assertEquals(priceTotal,burger.getPrice(),0.05);
    }
}


