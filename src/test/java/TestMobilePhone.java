//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestMobilePhone {
    private WebDriver driver;
    private MainPage mainPage;
    private ElectronicsTechnic electronicsTechnic;
    private PageCatalogMobilePhone pageCatalogMobilePhone;
    private Logic logic;

    @Before
    public void setUp(){
        DriverLoader driverLoader = new DriverLoader();
        driverLoader.DriverLoader();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");

        mainPage = new MainPage(driver);
        electronicsTechnic = new ElectronicsTechnic(driver);
        pageCatalogMobilePhone = new PageCatalogMobilePhone(driver);
        logic = new Logic(driver);


        try {
            mainPage.closeJS();
            mainPage.clickProductsElectronics();
        } catch (Exception e){
            mainPage.clickProductsElectronics();
            System.out.println(e);
        }
        try {
            electronicsTechnic.clickLeftMenuMobilePhone();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void firstTestMobile(){
        try {
            pageCatalogMobilePhone.clickCheckox("Apple");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct("TitleProductPhone");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assert.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()){
                Assert.assertTrue(catalog.contains("Apple"));
                System.out.println(catalog);
            }
        }
    }

    @Test
    public void SecondTestMobile(){
        try {
            pageCatalogMobilePhone.clickCheckox("Apple");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogMobilePhone.clickCheckox("Meizu");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct("TitleProductPhone");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assert.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()) {
                Assert.assertTrue(catalog.contains("Apple") || catalog.contains("Meizu"));
                System.out.println(catalog);
            }
        }
    }

    @Test
    public void SortPriseTestASC() {
        try {
            pageCatalogMobilePhone.clickCheckox("Honor");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            mainPage.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort(">", "Price");
        } catch (Exception e){
            System.out.println(e);
        }

        Assert.assertEquals(true, logic.isBool());
    }

    @Test
    public void SortPriseTestDESC() {
        try {
            pageCatalogMobilePhone.clickCheckox("OnePlus");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            mainPage.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            mainPage.clickTopSort();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort("<", "Price");
        } catch (Exception e){
            System.out.println(e);
        }

        Assert.assertEquals(true, logic.isBool());
    }

    @Test
    public void SortSaleTest() {
        try {
            pageCatalogMobilePhone.clickCheckox("LG");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(10000);
            mainPage.clickSale();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataCollectionPriceSort("<", "Sale");
        } catch (Exception e){
            System.out.println(e);
        }

        Assert.assertEquals(true, logic.isBool());
    }
    @Test
    public void RemoveCheckboxTest(){
        try {
            pageCatalogMobilePhone.clickCheckox("Samsung");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogMobilePhone.clickCheckox("Sony");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogMobilePhone.clickCheckox("Sony");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct("TitleProductPhone");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assert.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()) {
                Assert.assertTrue(catalog.contains("Samsung"));
                System.out.println(catalog);
            }
        }
    }

    @Test
    public void HiddenCheckboxMobilePhone(){
        try {
            pageCatalogMobilePhone.clickButtonShowAll();
        } catch (Exception e){
            System.out.println(e);
        }
        try{
            pageCatalogMobilePhone.searchElement("Moto");
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            pageCatalogMobilePhone.clickCheckox("Motorola");
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Thread.sleep(10000);
            logic.dataСollectionNameProduct("TitleProductPhone");
        } catch (Exception e){
            System.out.println(e);
        }
        if (logic.getTitleAll().size() <= 0){
            Assert.assertTrue(false);
        } else{
            for (String catalog: logic.getTitleAll()){
                Assert.assertTrue(catalog.contains("Motorola"));
                System.out.println(catalog);
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
