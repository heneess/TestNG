package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C03_MouseActions1 extends TestBase {
    //     1- Yeni bir class olusturalim: C03_MouseActions1
    // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // 3- Cizili alan uzerinde sag click yapalim
    // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //    test edelim.
    // 5- Tamam diyerek alert’I kapatalim
    // 6- Elemental Selenium linkine tiklayalim
    // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim


    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        String expectedAllertYazisi="You selected a context menu";
        String actualAllertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualAllertYazisi,expectedAllertYazisi,"allert yazisi beklenenden farkli");
        driver.switchTo().alert().accept();

        String ilkSayfaHandle=driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> windowTumHandlelar=driver.getWindowHandles();

        String ikinciSayfaHandle="";
        for (String each:windowTumHandlelar
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);
        String expectedikinciSayfaYazi="Elemental Selenium";
        String actualikinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualikinciSayfaYazisi,expectedikinciSayfaYazi,"ikinci sayfadaki yazi istenilenden farkli");

    }

}


