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

public class GetMale {
    WebDriver driver;
    WebDriverWait wait;

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

    @Test
    public void checkBoxes() {

        try {

            WebElement popUp1 = driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']"));
            wait.until(ExpectedConditions.elementToBeClickable(popUp1));

            popUp1.click();

        }
        catch (Throwable th) {

        }

        WebElement inputFormsButton = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputFormsButton.click();
        WebElement radioButtonsDemo = driver.findElement(By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']"));
        radioButtonsDemo.click();
        driver.findElement(By.xpath("//div[contains(h4, 'Sex')]//input[@value='Male']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        String result = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
        System.out.println(result);
        Assert.assertEquals("Sex : Male\nAge group: 15 - 50", result  );


    }
}



