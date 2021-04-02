import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MorbiLeoRisus extends BaseClass{
    private By listBox = By.xpath("//b[@class='caret']/parent::a[contains(text(), 'List Box')]");
    private By bootstrapListBox = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Bootstrap List Box')]");
    private By morbiElement = By.xpath("//div[contains(@class, 'well text-right')]//ul[@class='list-group']/li[text()='Morbi leo risus']");
    private By chevronRightButton = By.xpath("//span[contains(@class,'chevron-right')]");
    private By listOfElements = By.xpath("//div[contains(@class, 'list-right col-md-5')]//li");
    int expectedNumberOfElements = 2;


    @Test
    public void checkMorbi() {
        closePopup();
        find(listBox).click();
        find(bootstrapListBox).click();
        WebElement morbi = find(morbiElement);
        waitUntilClickable(morbi);
        morbi.click();
        find(chevronRightButton).click();

        List<WebElement> listGroup = findElements(listOfElements);

        int actualNumberOfElements = findNumberOfElements(listGroup);
        Assert.assertEquals(expectedNumberOfElements, actualNumberOfElements);

    }
}





