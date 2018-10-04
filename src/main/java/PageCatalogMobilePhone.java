import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCatalogMobilePhone {
    private WebDriver driver;
    private String xpathCheckPhone = "//span[text()='%s']";
    private By titleElementPhone = By.xpath("//div[@class=\"n-snippet-cell2__header\"]//div[@class=\"n-snippet-cell2__title\"]");

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
}
