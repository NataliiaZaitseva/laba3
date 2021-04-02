import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClickCancelButton extends BaseClass{
    private By alertsAndModalsTab = By.xpath("//li[@class='dropdown']//a[contains(text(), 'Alerts & Modals')]");
    private By javascriptAlertsSection = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Javascript Alerts')]");
    private By confirmButton = By.xpath("//b[contains(text(), 'Click the button to display an confirm')]/following-sibling::button");
    private By actualText = By.xpath("//p[@id='confirm-demo']");
    String expectedText = "You pressed Cancel!";

    @Test
    public void clickCancelButton() {

        closePopup();

        find(alertsAndModalsTab).click();
        find(javascriptAlertsSection).click();
        waitUntilClickable(find(confirmButton));
        javascriptExecute(confirmButton);

        alertDismiss();

        Assert.assertEquals(expectedText, find(actualText).getText());











    }
}





