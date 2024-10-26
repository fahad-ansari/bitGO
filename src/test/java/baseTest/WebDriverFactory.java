package baseTest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public Map<String, Supplier<WebDriver>> driverMap= null;

    public WebDriverFactory() {
        driverMap = new HashMap<>();
        driverMap.put("chrome", this::CreateChromeDriver);
        driverMap.put("firefox", this::CreateFireFoxDriver);
    }

    private WebDriver CreateChromeDriver(){
        return new ChromeDriver();
    }

    private WebDriver CreateFireFoxDriver(){
        return new FirefoxDriver();
        }


    public WebDriver getDriver(String browsername) {
        return driverMap.getOrDefault(browsername.toLowerCase().trim(), () -> {
            System.out.println("browser not found"+browsername);
            return null;
        }).get();
    }
}

