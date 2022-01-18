package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

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

        System.out.println("ilk sayfanin handle degeri : "+driver.getWindowHandle());
        // window handle ederken ilk adim bir sayfa acıkken o sayfanin handle degerini alip
        // stringe atamak

        String ilkSayfaHandle=driver.getWindowHandle();



        driver.findElement(By.linkText("Click Here")).click();
        //2.adim iki sayfa acildiginda her iki sayfanin handle degerini bulmak icin
        //bir set olusturup get windows handle methoduyla bu degerleri elde etmek

        Set<String> tumWindowHandlelari= driver.getWindowHandles();
        System.out.println("Tum Handlelar : "+tumWindowHandlelari);

        //3.adim birinci sayfanin handle degerine esit olmayan handle degerini bulup
        // bir string degiskenine atamak

        String ikinciWindowHandle="";
        for (String each:tumWindowHandlelari
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciWindowHandle=each;
            }
        }
        //bu satira geldigimizde elimizde 2.sayfanin handle degeri var olacak

        System.out.println("ikinci sayfa handle degeri : "+ikinciWindowHandle);

        driver.switchTo().window("");
        //switchTo ile window degistireceksek gidecegiimiz windowhandle degerine ihtiyacimiz var

        String actualYeniTitle=driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"yani sayfanin title'i yanlis");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualSayfaYaziYeniSayfa=yeniSayfaYaziElementi.getText();
        softAssert.assertEquals(actualSayfaYaziYeniSayfa,expectedYaziYeniSayfa,"yeni sayfadaki yazi beklenenden farkli");
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");

        softAssert.assertAll();


    }

}


