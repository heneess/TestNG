package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist  {

    @Test
    public void Test(){
        System.out.println(System.getProperty("user.home"));
        //C:\Users\Ryzen 5\Desktop\picture.jpg

        //masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsu calismasi icin 2 ye ayiracagiz
        //1-herkesin bilgisayarinda farkli olan kismi
        // bu kismi bilgisayardan Syste.getProperty("user.home") kodu ile alabiliriz
        //2 herkes icin ayni olan kisim
        //bu kisim 1. maddedeki yolun devami seklinde olur

        //masaustundeki picture dosyasi icin yol kaydedelim

        String dosyaYolu=System.getProperty("user.home") +"\\Desktop\\picture.jpg";

        String dosyayoluManuel="C:\\Users\\Ryzen 5\\Desktop\\picture.jpg";

        System.out.println("dosya yolumuz : "+dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(dosyayoluManuel)));

        System.out.println(System.getProperty("user.dir"));


    }

}

