import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By buttonProductComputers = By.cssSelector("li.topmenu__item:nth-child(2) > a:nth-child(1)");
    private By buttonSignIn = By.xpath("//span[text()='Войти']");
    private By buttonJS = By.cssSelector(".button2_theme_action");

    public MainPage closeJS(){
        driver.findElement(buttonJS).click();
        return this;
    }

    public ComputersTechnic clicProductLaptop(){
        driver.findElement(buttonProductComputers).click();
        return new ComputersTechnic(driver) ;
    }

}
