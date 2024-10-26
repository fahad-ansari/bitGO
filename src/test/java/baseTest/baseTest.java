package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import pages.blocksPage;

public class baseTest extends WebDriverFactory {

    public WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverFactory browser = new WebDriverFactory();
        driver = browser.getDriver("chrome");
        driver.manage().window().maximize();
    }

    public blocksPage launchApp(){
        blocksPage bn = new blocksPage(driver);
        bn.goToPage();
        return bn;
    }

}

