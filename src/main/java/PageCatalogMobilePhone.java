import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  в этом классе описана страница с каталогом мобильных телефонов
 *  */

public class PageCatalogMobilePhone {
    private WebDriver driver;
    private String xpathCheckPhone = "//span[text()='%s']";
    private By titleElementPhone = By.xpath("//div[@class=\"n-snippet-cell2__header\"]//div[@class=\"n-snippet-cell2__title\"]");
    private By buttonShowAll = By.cssSelector("div._2Hue1bCg-N:nth-child(4) > fieldset:nth-child(1) > footer:nth-child(3) > a:nth-child(1)");
    private By nameElement = By.id("7893318-suggester");

    public By getTitleElementPhone() {
        return titleElementPhone;
    }

    public PageCatalogMobilePhone(WebDriver driver){
        this.driver = driver;
    }

    // проставляет чекбокс is selected не работает
    public PageCatalogMobilePhone clickCheckox(String nameCheckbox){
        //должно проверять активный ли чекбокс проверить это когда нибудь
        if(!driver.findElement(By.xpath(String.format(xpathCheckPhone, nameCheckbox))).isSelected())
            driver.findElement(By.xpath(String.format(xpathCheckPhone, nameCheckbox))).click();
        return this;
    }

    // этот метод будет снимать выделение чекбокса необходимо его проверить is selected не работает
    public PageCatalogMobilePhone deselectCheckbox(String nameCheckbox){
        //должно проверять активный ли чекбокс проверить это когда нибудь
        if(driver.findElement(By.xpath(String.format(xpathCheckPhone, nameCheckbox))).isSelected())
            driver.findElement(By.xpath(String.format(xpathCheckPhone, nameCheckbox))).click();
        return this;
    }

    public PageCatalogMobilePhone searchElement(String nameProduct){
        driver.findElement(nameElement).sendKeys(nameProduct);
        return new PageCatalogMobilePhone(driver);
    }

    public PageCatalogMobilePhone clickButtonShowAll(){
        driver.findElement(buttonShowAll).click();
        return new PageCatalogMobilePhone(driver);
    }

}
