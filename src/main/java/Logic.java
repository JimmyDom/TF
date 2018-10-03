import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    static WebDriverWait wait;
    private WebDriver driver;
    private List <WebElement> catalog;
    private ArrayList <Integer> titleList = new ArrayList();
    private ArrayList <String> titleAll = new ArrayList();
    private boolean bool = false;
    By cssSelectorDataCollection;

    PageCatalogLaptop pageCatalogLaptop = new PageCatalogLaptop(driver);


    public Logic(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<String> getTitleAll() {
        return titleAll;
    }

    public List <WebElement> getCatalog() {
        return catalog;
    }

    public boolean isBool() {
        return bool;
    }


    public void dataСollectionNameProduct(String title) {
//        wait = (new WebDriverWait(driver, 10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(pageCatalogLaptop.getImageProductLaptop()));

        if (title.equals("TitleProduct")){  // присваиваем cssSelector взависимости от того какой тест выполняем
           cssSelectorDataCollection = pageCatalogLaptop.getTitleElement();
        }
        else if (title.equals("Price")){
            cssSelectorDataCollection = pageCatalogLaptop.getPriceElement();
        }
        else if (title.equals("Sale")){
            cssSelectorDataCollection = pageCatalogLaptop.getSaleElement();
        }

        for (int i = 0; i < 5; i++) {   //        цикл пролистывает страницы, и добавляет данные в массив

            try {
                Thread.sleep(10000);
                catalog = driver.findElements(cssSelectorDataCollection);

                for(WebElement catalog1 : catalog ) {
                    titleAll.add(catalog1.getText());
                }
                driver.findElement(pageCatalogLaptop.getButtonNext()).click();
            } catch (Exception e) {
                break;
            }
        }
    }


    public void dataCollectionPriceSort(String symbol, String whatElement){
        // присваиваем переменную title методу dataСollectionNameProduct
        if (whatElement.equals("Price")) {
             dataСollectionNameProduct(whatElement);
        }
        else if (whatElement.equals("Sale")){
            dataСollectionNameProduct(whatElement);
        }
        System.out.println(titleAll.size());

        // распарсенные данные переносим в массив в числовом виде
        for (String catalog: titleAll){
            String str = catalog;
            str = str.replaceAll("\\D+",""); // эта штука оставляет только цифры из поступающих данных
            titleList.add(Integer.valueOf(str));
        }

        if (symbol.equals("<")) {   //desc for price
            for (int i = 0; i < titleList.size(); i++) {
                try {
                    if (titleList.get(i) < titleList.get(i + 1)) {
                        bool = false;
                        break;
                    } else {
                        bool = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.println(bool);
            }
        }
        else if (symbol.equals(">")){   //asc for price
            for (int i = 0; i < titleList.size(); i++) {
                try {
                    if (titleList.get(i) > titleList.get(i + 1)) {
                        bool = false;
                        break;
                    } else {
                        bool = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } System.out.println(bool);
            }
        }
    }


}
