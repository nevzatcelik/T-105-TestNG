package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemy_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualityDemyTest1 {
    String url2="https://www.google.com";
    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // categories dropdown dan all courses secenegine tiklayin
    // acilan sayfada olan derslerden The English Master Course dersine tiklayin
    // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
    // stripe secenegini secerek pay with stripe e tiklayin
    // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin
    Actions actions=new Actions(Driver.getDriver());
   QualityDemy_Page quality=new QualityDemy_Page();
    @Test
    public void qualityDemyTest(){
        //qualityDemy web sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        quality.loginMethodu();
        // categories dropdown dan all courses secenegine tiklayin
        ReusableMethods.bekle(5);

        actions.moveToElement(quality.categories).clickAndHold(quality.categories).
                moveToElement(quality.allCourses).click(quality.allCourses).perform();
        // acilan sayfada olan derslerden The English Master Course dersine tiklayin
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(1);
        quality.secondPage.click(); actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        quality.english.click();
        // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
        quality.buyButton.click();
        quality.checkoutButton.click();
        // stripe secenegini secerek pay with stripe e tiklayin
        quality.stripeButton.click();
        quality.payWithStripeButton.click();
        // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin
        //quality.payWithCard();
        quality.payWithCard();




    }
    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // anasayfadan java kursunu secelim
    // acilan sayfada ders add to wishlist e eklenir
    // urunun eklendigi test edilir
    // eklenilen urun wishlistten cikarilir
    //cikarildigi test ediliri
     @Test
    public void test2(){
         //qualityDemy web sayfasina gidin
         Driver.getDriver().get(ConfigReader.getProperty("url"));
         // cookies i kabul edin
         // login linkine tiklayin
         // email ve password bilgilerini girerek login butonuna tiklayin
         quality.loginMethodu();
         // anasayfadan java kursunu secelim

         actions.
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).perform();
         ReusableMethods.bekle(2);
         quality.javaKursu.click();
         // acilan sayfada ders add to wishlist e eklenir
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         ReusableMethods.bekle(1);
         quality.addWishList.click();
         ReusableMethods.bekle(2);
         actions.sendKeys(Keys.HOME).perform();
         ReusableMethods.bekle(2);
         actions.moveToElement(quality.wishListIcon).click(quality.goToWishListButton).perform();
         Assert.assertTrue(quality.javaKursu.isDisplayed());
         // eklenilen urun wishlistten cikarilir
         //cikarildigi test ediliri
         quality.wishListCikarma.click();
         ReusableMethods.bekle(2);
         quality.yesButton.click();
         Assert.assertFalse(quality.javaKursu.isDisplayed());
     }
    }

