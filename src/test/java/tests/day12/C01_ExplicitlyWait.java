package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {

    //     1. Bir class olusturun : C01_WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //   Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest(){

        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        SoftAssert softAssert=new SoftAssert();

        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));

        softAssert.assertTrue(sonucYazisi.isDisplayed());
        softAssert.assertAll();

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(sonucYazisi.isDisplayed());


    }

    @Test
    public void explicitlyWaitTest(){

        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebDriverWait wait=new WebDriverWait(driver,20);

        //explicity wait istersek locate islemi ile birlikte tek satirda yapabiliriz
/*
        WebElement yaziLocateileBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(yaziLocateileBirlikte.isDisplayed());
  */
        //veya once locate edip uygun method kullanarak beklemeyi yaptırabiliriz
        //ancak bu test iciin webelementi olusturmak anlamsiz olur cunku
        // biz wait silemi zaten o web element olussun diye yapiyoruz
        //wait olmadan o element olmaz , o element olmadan da sectigimiz method calismaz

/*
        WebElement sonucYazisi= driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
   */
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement itsbacklocateile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsbacklocateile.isDisplayed());
    }
}
