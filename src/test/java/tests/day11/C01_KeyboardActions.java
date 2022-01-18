package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.plaf.TableHeaderUI;

public class C01_KeyboardActions extends TestBase {

    //     1- Bir Class olusturalim C01_KeyboardActions1
    // 2- https://www.amazon.com sayfasina gidelim
    // 3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve
    // Enter’a basarak arama yaptirin
    // 4- aramanin gerceklestigini test edin

    @Test
    public void Test() throws InterruptedException {
        // 2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve
        // Enter’a basarak arama yaptirin

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions= new Actions(driver);

        actions.click(aramaKutusu)
                .sendKeys("samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(2000);

        // 4- aramanin gerceklestigini test edin

        String arananKelime="samsung A71";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime),"arama yapilamadi !");



    }

}
