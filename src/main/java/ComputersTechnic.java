import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ComputersTechnic {
    private WebDriver driver;
    private By buttonLeftMenuLaptop = By.cssSelector("._8Pmmsj8JJD > div:nth-child(1) > div:nth-child(1) > " +
            "div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");


    public ComputersTechnic(WebDriver driver){
        this.driver = driver;
    }

    public PageCatalogLaptop clickLeftMenuLaptop(){
        driver.findElement(buttonLeftMenuLaptop).click();
        return new PageCatalogLaptop(driver);
    }
}
