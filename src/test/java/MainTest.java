import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
        private WebDriver driver;
        private MainPage mainPage;
        private ComputersTechnic computersTechnic;
        private PageCatalogLaptop pageCatalogLaptop;
        private Logic logic;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/TF/src/main/resources/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");
        mainPage = new MainPage(driver);
        computersTechnic = new ComputersTechnic(driver);
        pageCatalogLaptop = new PageCatalogLaptop(driver);
        logic = new Logic(driver);
    }

    @Test
    public void firstTest(){
        try {
            mainPage.closeJS();
            mainPage.clicProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("ASUS");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct();
        } catch (Exception e){
            System.out.println(e);
        }
        for (WebElement catalog: logic.getCatalog()){
            assertTrue(catalog.getText().contains("ASUS"));
            System.out.println(catalog.getText());
        }


    }
    @Test
    public void SecondTest(){
        try {
            mainPage.closeJS();
            mainPage.clicProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Apple");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Xiaomi");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct();
        } catch (Exception e){
            System.out.println(e);
        }
        for (WebElement catalog: logic.getCatalog()){
            assertTrue(catalog.getText().contains("Apple") || catalog.getText().contains("Xiaomi"));
            System.out.println(catalog.getText());
        }
    }

    @Test
    public void SortPriseTestASC() {
        try {
            mainPage.closeJS();
            mainPage.clicProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Prestigio");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            pageCatalogLaptop.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort(">", "Price");
        } catch (Exception e){
            System.out.println(e);
        }
        
        assertEquals(true, logic.isBool());
    }

    @Test
    public void SortPriseTestDESC() {
        try {
            mainPage.closeJS();
            mainPage.clicProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Lenovo");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            pageCatalogLaptop.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            pageCatalogLaptop.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort("<", "Price");
        } catch (Exception e){
            System.out.println(e);
        }

        assertEquals(true, logic.isBool());
    }

    @Test
    public void SortSaleTest() {
        try {
            mainPage.closeJS();
            mainPage.clicProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Apple");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            pageCatalogLaptop.clickSale();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort("<", "Sale");
        } catch (Exception e){
            System.out.println(e);
        }

        assertEquals(true, logic.isBool());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
