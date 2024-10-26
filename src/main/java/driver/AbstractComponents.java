package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
