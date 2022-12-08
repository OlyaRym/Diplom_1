import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void getNameTest(){

        Bun bun = new Bun("Olya", 100);
        String expectedName = "Olya";

        String actualName = bun.getName();

        Assert.assertEquals("Name is incorrect", expectedName,actualName);
    }
    @Test
    public void getPriceTest(){

        Bun bun = new Bun("Olya", 100);
        float expectedPrice = 100;

        float actualPrice = bun.getPrice();

        Assert.assertEquals("Price is incorrect",expectedPrice,actualPrice,0.05);
    }
}


