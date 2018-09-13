import java.util.Properties;


public class DriverLoader {

    public void DriverLoader() {

        Properties config = new Properties();

        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.setProperty("webdriver.chrome.driver", config.getProperty("chrome_executable_path"));
//        System.setProperty("webdriver.gecko.driver", config.getProperty("firefox_executable_path"));

    }

}
