import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;


    By advertisementPopUp = By.xpath("//a[@id='at-cv-lightbox-close']");

    @Before
    public void openSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
    }

    @After
    public void closeSite() {

        driver.close();
    }

    public void closePopup() {
        try {

            WebElement popUp1 = driver.findElement(advertisementPopUp);
            waitUntilClickable(popUp1);

            popUp1.click();

        }
        catch (Throwable th) {

        }
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        List<WebElement> listGroup = driver.findElements(locator);
        return listGroup;

    }

    public int findNumberOfElements(List<WebElement> list) {
        int i = 0;
        for (WebElement element: list) {
            if (element.getText().equals("Morbi leo risus")) {
                i++;
            }
        }
        return i;
    }

    public void javascriptExecute(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", find(locator));
    }

    public void alertDismiss() {
        try{
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();

            alert.dismiss();

        } catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();
        }
    }



}
