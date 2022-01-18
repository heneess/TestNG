package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
    /*
    ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");

        String actualYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="Opening a new window";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualYazi,expectedYazi,"yazi istendigi gibi degil");

        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenilen degerden farkli");

        driver.findElement(By.linkText("Click Here")).click();

        String actualYeniTİtle=driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actualYeniTİtle,expectedYeniTitle,"yani sayfanin title'i yanlis");

        softAssert.assertAll();


    }

}
