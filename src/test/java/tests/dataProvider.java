package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemy_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class dataProvider {
     QualityDemy_Page demy_page=new QualityDemy_Page();
    @DataProvider
    public static Object[][] gonderilecekLogin(){
        Object[][] gonderilecekMailPassword={{ConfigReader.getProperty("yanlismail1"),ConfigReader.getProperty("yanlisPass1")},
                {ConfigReader.getProperty("yanlismail2"),ConfigReader.getProperty("yanlisPass2")}
                ,{ConfigReader.getProperty("yanlismail3"),ConfigReader.getProperty("yanlisPass3")},
                {ConfigReader.getProperty("mail"),ConfigReader.getProperty("password")}};

        return gonderilecekMailPassword;
    }

    @Test(dataProvider = "gonderilecekLogin")
    public void qualityTest(String gonderilecekMail,String gonderilecekPassword){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        demy_page.gonderilecekMailvePassword(gonderilecekMail,gonderilecekPassword);


    }
}
