package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualityDemy_Page {
    Actions actions=new Actions(Driver.getDriver());
    public QualityDemy_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Accept']")
    private WebElement cookies;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    private WebElement loginButton;

    public void loginMethodu(){
        cookies.click();
        loginLink.click();
        emailBox.sendKeys(ConfigReader.getProperty("mail"));
        passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();
    }


    @FindBy(xpath = "//*[text()='Categories']")
    public WebElement categories;

    @FindBy(xpath = "(//*[text()='All courses'])[1]")
    public WebElement allCourses;

    @FindBy(xpath = "//*[text()='2']")
    public WebElement secondPage;

    @FindBy(xpath = "(//a[@class='course-title'])[5]")
    public WebElement english;

    @FindBy(xpath = "(//div[@class='col-md-12'])[10]")
    public WebElement photo;

    @FindBy(xpath = "//button[@class='btn btn-buy']")
    public WebElement buyButton;

    @FindBy(xpath = "//button[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='row payment-gateway stripe']")
    public WebElement stripeButton;

    @FindBy(xpath = "//button[text()='Pay with stripe']")
    public WebElement payWithStripeButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement payEmailBox;

    @FindBy(xpath = "//div[@class='SubmitButton-IconContainer']")
    private WebElement payButton;

    public void payWithCard(){
        actions.sendKeys(payEmailBox,"anevzatcelik@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("4242424242424242")
                .sendKeys(Keys.TAB).sendKeys("1124")
                .sendKeys(Keys.TAB).sendKeys("325")
                .sendKeys(Keys.TAB).sendKeys("ahmet").click(payButton).perform();
    }

    @FindBy(xpath = "//h5[text()=' Java Kursu']")
    public WebElement javaKursu;
    @FindBy(xpath = "//button[@class='btn btn-add-wishlist ']")
    public WebElement addWishList;
    @FindBy(xpath = "(//div[@class='icon'])[3]")
    public WebElement wishListIcon;
    @FindBy(xpath = "//a[text()='Go to wishlist']")
    public WebElement goToWishListButton;

    @FindBy(xpath = "//button[@onclick='handleWishList(this)']")
    public WebElement wishListCikarma;
    @FindBy(xpath = "//a[@class='btn btn-danger btn-yes']")
    public WebElement yesButton;

    public void gonderilecekMailvePassword(String gonderilecekMail,String gonderilecekPassword){
        if (cookies.isDisplayed()) {
            cookies.click();
            loginLink.click();
            emailBox.sendKeys(gonderilecekMail);
            passwordBox.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(5);
        }else {
           loginLink.click();
            emailBox.sendKeys(gonderilecekMail);
            passwordBox.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(5);
        }
        loginButton.click();
    }

}
