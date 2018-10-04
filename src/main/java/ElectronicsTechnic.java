import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsTechnic {
    private WebDriver driver;
    private By buttonLeftMenuMobilePhone = By.cssSelector("div._1YdrMWBuYy:nth-child(1) > div:nth-child(2) > " +
            "div:nth-child(1) > a:nth-child(1)");


    public ElectronicsTechnic(WebDriver driver){
        this.driver = driver;
    }

    public PageCatalogMobilePhone clickLeftMenuMobilePhone(){
        driver.findElement(buttonLeftMenuMobilePhone).click();
        return new PageCatalogMobilePhone(driver);
    }

}
