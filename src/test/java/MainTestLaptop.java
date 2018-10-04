import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainTestLaptop {
        private WebDriver driver;
        private MainPage mainPage;
        private ComputersTechnic computersTechnic;
        private PageCatalogLaptop pageCatalogLaptop;
        private Logic logic;

    @BeforeEach
    public void setUp() {

        DriverLoader driverLoader = new DriverLoader();
        driverLoader.DriverLoader();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");

        mainPage = new MainPage(driver);
        computersTechnic = new ComputersTechnic(driver);
        pageCatalogLaptop = new PageCatalogLaptop(driver);
        logic = new Logic(driver);

        try {
            mainPage.closeJS();
            mainPage.clickProductLaptop();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            computersTechnic.clickLeftMenuLaptop();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void firstTestLaptop(){
        try {
            pageCatalogLaptop.clickCheckbox("ASUS");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct("TitleProduct");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assertions.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()){
                Assertions.assertTrue(catalog.contains("ASUS"));
                System.out.println(catalog);
            }
        }
    }
    @Test
    public void SecondTestLaptop(){
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
            logic.dataСollectionNameProduct("TitleProduct");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assertions.assertTrue(false);
        } else{
        for (String catalog: logic.getTitleAll()) {
            Assertions.assertTrue(catalog.contains("Apple") || catalog.contains("Xiaomi"));
            System.out.println(catalog);
            }
        }
    }

    @Test
    public void SortPriseTestASC() {
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

        Assertions.assertEquals(true, logic.isBool());
    }

    @Test
    public void SortPriseTestDESC() {
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

        Assertions.assertEquals(true, logic.isBool());
    }

    @Test
    public void SortSaleTest() {
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

        Assertions.assertEquals(true, logic.isBool());
    }
    @Test
    public void RemoveCheckboxTest(){
        try {
            pageCatalogLaptop.clickCheckbox("Alienware");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogLaptop.clickCheckbox("Xiaomi");
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
            logic.dataСollectionNameProduct("TitleProduct");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assertions.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()) {
                Assertions.assertTrue(catalog.contains("Alienware"));
                System.out.println(catalog);
            }
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
