package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {

    @Test
    public void test(){
        /*
                 Yeni bir class olusturalim: D14_MouseActions2
         1- https://demoqa.com/droppable adresine gidelim
         2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
         3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        */

        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        WebElement dragElement=driver.findElement(By.id("draggable"));
        WebElement dropAlani=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragElement,dropAlani).perform();
        WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String actualDroppedYazisi=dropped.getText();
        String expectedDroppedYazisi="Dropped!";

        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi,"dropped yazisi beklenenden farkli");




    }


}
