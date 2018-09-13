import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCatalogLaptop {
    private WebDriver driver;

    public PageCatalogLaptop(WebDriver driver){
        this.driver = driver;
    }

    private String checkXpath = "//span[text()='%s']";
    private By buttonNext = By.cssSelector("a.button:nth-child(7)");
    private By topSortPrice = By.cssSelector("div.n-filter-sorter:nth-child(3) > a:nth-child(1)");
    private By buttonTopSale = By.cssSelector("div.n-filter-sorter:nth-child(6) > a:nth-child(1)");
    private By titleElement = By.xpath("//div[@class=\"n-snippet-card2__header n-snippet-card2__header_has_rating\"]//div[@class=\"n-snippet-card2__title\"]");
    private By priceElement = By.xpath("//div[@class=\"price\"]");
    private By saleElement = By.xpath("//div[@class=\"stickers__sticker stickers__sticker_type_discount\"]");
    private By imageProductLaptop = By.xpath("//a[@class=\"n-snippet-card2__image link link_type_cpc i-bem link_js_inited\"]/img[@class=\"image\"]");

    public By getTitleElement() {
        return titleElement;
    }
    public By getPriceElement() {
        return priceElement;
    }
    public By getButtonNext() {
        return buttonNext;
    }
    public By getSaleElement() {
        return saleElement;
    }


    // проставляет чекбокс is selected не работает
    public PageCatalogLaptop clickCheckbox(String nameCheckbox){
        if(!driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).isSelected()) //должно проверять активный ли чекбокс проверить это когда нибудь
            driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).click();
        return this;
    }
    // этот метод будет снимать выделение чекбокса необходимо его проверить is selected не работает
    public PageCatalogLaptop deselectCheckbox(String nameCheckbox){
        if(driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).isSelected()) //должно проверять активный ли чекбокс проверить это когда нибудь
        driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).click();
        return this;
    }
    public PageCatalogLaptop clickNext(){
        driver.findElement(buttonNext).click();
        return this;
    }
    public PageCatalogLaptop clickTopSort() {
        driver.findElement(topSortPrice).click();
        return this;
    }
    public PageCatalogLaptop clickSale(){
        driver.findElement(buttonTopSale).click();
        return  this;
    }

}
