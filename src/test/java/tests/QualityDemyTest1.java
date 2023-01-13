package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
   QualityDemy_Page quality=new QualityDemy_Page();
    @Test
    public void qualityDemyTest(){
        //qualityDemy web sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("nevzat@gmail.com"));
        quality.loginMethodu();
        // categories dropdown dan all courses secenegine tiklayin
        ReusableMethods.bekle(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(quality.categories).clickAndHold(quality.categories).
                moveToElement(quality.allCourses).click(quality.allCourses).perform();
        // acilan sayfada olan derslerden The English Master Course dersine tiklayin
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(1);
        quality.secondPage.click();
        // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        quality.english.click();
        // stripe secenegini secerek pay with stripe e tiklayin
        // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin


    }

    }

