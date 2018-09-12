import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private WebDriver driver;
    private List <WebElement> catalog;
    private ArrayList <Integer> titleList = new ArrayList();
    private boolean bool = false;
    PageCatalogLaptop pageCatalogLaptop = new PageCatalogLaptop(driver);


    public Logic(WebDriver driver) {
        this.driver = driver;
    }

    public List <WebElement> getCatalog() {
        return catalog;
    }

    public boolean isBool() {
        return bool;
    }

    public void dataСollectionNameProduct() {

        catalog = driver.findElements(pageCatalogLaptop.getTitleElement());

//        цикл пролистывает страницы, и добавляет данные в лист catalog
//        for (int i = 0; i < 10; i++) {
//
//            try {
//                Thread.sleep(10000);
//                catalog = driver.findElements(pageCatalogLaptop.getTitleElement());
//                number += catalog.size();
//                System.out.println(number);
//                driver.findElement(pageCatalogLaptop.getButtonNext()).click();
//            } catch (Exception e) {
//                System.out.println("yps");
//                break;
//            }
//        }
    }


    public void dataCollectionPriceSort(String symbol, String whatElement){

        if (whatElement.equals("Price")) {
            catalog = driver.findElements(pageCatalogLaptop.getPriceElement());
        }
        else if (whatElement.equals("Sale")){
            catalog = driver.findElements(pageCatalogLaptop.getSaleElement());
        }
        System.out.println(catalog.size());

// распарсенные данные переносим в массив в числовом виде
        for (WebElement catalog: catalog){
            String str = catalog.getText();
            str = str.replaceAll("\\D+",""); // эта штука оставляет только цифры из поступающих данных
            titleList.add(Integer.valueOf(str));
        }

        if (symbol.equals("<")) { //desc for price
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
        else if (symbol.equals(">")){ //asc for price
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
