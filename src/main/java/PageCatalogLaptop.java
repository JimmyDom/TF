import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  в этом классе описана страница с каталогом ноутбуков
 *  */

public class PageCatalogLaptop {
    private WebDriver driver;
    private String checkXpath = "//span[text()='%s']";
    private By buttonNext = By.cssSelector("a.button:nth-child(7)");
    private By titleElement = By.xpath("//div[@class=\"n-snippet-card2__header n-snippet-card2__header_has_rating\"]" +
            "//div[@class=\"n-snippet-card2__title\"]");
    private By imageProductLaptop = By.xpath("//a[@class=\"link i-bem link_js_inited\"]//img[@class=\"footer-market__promo-image\"]");
    private By buttonShowAll = By.cssSelector("div._2Hue1bCg-N:nth-child(4) > fieldset:nth-child(1) > footer:nth-child(3) > a:nth-child(1)");
    private By nameElement = By.id("7893318-suggester");

    public PageCatalogLaptop(WebDriver driver){
        this.driver = driver;
    }

    public By getTitleElement() {
        return titleElement;
    }
    public By getButtonNext() {
        return buttonNext;
    }
    public By getImageProductLaptop() {
        return imageProductLaptop;
    }


    // проставляет чекбокс is selected не работает
    public PageCatalogLaptop clickCheckbox(String nameCheckbox){
        //должно проверять активный ли чекбокс проверить это когда нибудь
        if(!driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).isSelected())
            driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).click();
        return this;
    }
    // этот метод будет снимать выделение чекбокса необходимо его проверить is selected не работает
    public PageCatalogLaptop deselectCheckbox(String nameCheckbox){
        //должно проверять активный ли чекбокс проверить это когда нибудь
        if(driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).isSelected())
        driver.findElement(By.xpath(String.format(checkXpath, nameCheckbox))).click();
        return this;
    }
    public PageCatalogLaptop clickNext(){
        driver.findElement(buttonNext).click();
        return this;
    }

    public PageCatalogLaptop searchElement(String nameProduct){
        driver.findElement(nameElement).sendKeys(nameProduct);
        return new PageCatalogLaptop(driver);
    }

    public PageCatalogLaptop clickButtonShowAll(){
        driver.findElement(buttonShowAll).click();
        return new PageCatalogLaptop(driver);
    }

}
