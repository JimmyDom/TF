import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By buttonProductComputers = By.cssSelector("li.topmenu__item:nth-child(2) > a:nth-child(1)");
    private By buttonProductElectronics = By.cssSelector("li.topmenu__item:nth-child(1) > a:nth-child(1)");
    private By buttonJS = By.cssSelector(".button2_theme_action");
    private By topSortPrice = By.cssSelector("div.n-filter-sorter:nth-child(3) > a:nth-child(1)");
    private By buttonTopSale = By.cssSelector("div.n-filter-sorter:nth-child(6) > a:nth-child(1)");
    //две переменные ниже представлены во всех страницах одинаковыми
    private By priceElement = By.xpath("//div[@class=\"price\"]");
    private By saleElement = By.xpath("//div[@class=\"stickers__sticker stickers__sticker_type_discount\"]");

    public By getPriceElement() {
        return priceElement;
    }
    public By getSaleElement() {
        return saleElement;
    }

    public MainPage closeJS(){
        driver.findElement(buttonJS).click();
        return this;
    }

    public ComputersTechnic clickProductLaptop(){
        driver.findElement(buttonProductComputers).click();
        return new ComputersTechnic(driver) ;
    }

    public ElectronicsTechnic clickProductsElectronics(){
        driver.findElement(buttonProductElectronics).click();
        return new ElectronicsTechnic(driver);
    }
    public void clickTopSort() {
        driver.findElement(topSortPrice).click();
    }

    public void clickSale(){
        driver.findElement(buttonTopSale).click();
    }

}
