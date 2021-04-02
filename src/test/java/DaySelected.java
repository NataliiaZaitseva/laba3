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


import java.util.concurrent.TimeUnit;

public class DaySelected extends BaseClass {

    private By inputFormsButton = By.xpath("//a[text()='Input Forms']");
    private By selectDropDownList = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    private By selectADayInputField = By.xpath("//select[@class='form-control']");
    private By selectFriday = By.xpath("//select[@class='form-control']//option[@value='Friday']");
    private By textActual = By.xpath("//p[@class='selected-value']");
    String expectedText = "Day selected :- Friday";


    @Test
    public void selectDay() {

        closePopup();
        find(inputFormsButton).click();
        find(selectDropDownList).click();

        find(selectADayInputField).click();
        find(selectFriday).click();
        String actualText = find(textActual).getText();
        Assert.assertEquals(expectedText, actualText);
    }
}



