package pages;

import driver.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class blocksPage extends AbstractComponents {

    WebDriver driver;

    public blocksPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void goToPage(){
        driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
    }

    public void checkContainsValue() {
        String expected = "25 of 2875 Transactions";
        WebElement textElement = driver.findElement(By.xpath("//h3[@class='font-h3']"));
        scroll(textElement);
        Assert.assertEquals(expected, String.valueOf(textElement.getText()), "String does not matched");

    }


    public void fetchTranscations () {

        List<WebElement> transactions = driver.findElements(By.xpath("//div[@id='transaction-box']"));

        for (WebElement transaction : transactions) {

            WebElement transactionHash = transaction.findElement(By.xpath("//div[@class='txn font-p2']//a"));

            int inputCount = transaction.findElements(By.cssSelector(".vin-header")).size();
            int outputCount = transaction.findElements(By.cssSelector(".vout-header")).size();

            // criteria if 1 input and 2 outputs
            if (inputCount == 1 && outputCount == 2) {
                System.out.println("Transaction Hash: " + transactionHash.getAttribute("href"));
            }
        }

    }


}
