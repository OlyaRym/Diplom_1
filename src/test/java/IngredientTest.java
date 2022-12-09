import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float expectedGetPrice = 100;
        float actualGetPrice = ingredient.getPrice();
        Assert.assertEquals("GetPrice is incorrect", expectedGetPrice,actualGetPrice,0.05);
    }
    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        String expectedGetName = "hot sauce";
        String actualGetName = ingredient.getName();
        Assert.assertEquals("GetName is incorrect", expectedGetName,actualGetName);
    }
    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        IngredientType expectedGetType = IngredientType.SAUCE;
        IngredientType actualGetType = ingredient.getType();
        Assert.assertEquals("GetType is incorrect", expectedGetType,actualGetType);
    }
}

