package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {
    WebDriver driver;

    int maxRetries = 3;

    BaseTest baseTest = new BaseTest();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-label='Naslovna']")
    WebElement homeButton;

    public void goToHomePage() {
        homeButton.click();
    }

    WebDriverWait webDriverWait;

    public void click(WebElement element) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void click(WebElement element, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).build().perform();
                element.click();
                System.out.println(getCurrentTimeAndDate() + " Clicked: " + log);
                break;
            } catch (Exception e) {
                retryCount++;
                System.out.println("Retry: " + retryCount + " to click on" + log);
                if (retryCount == maxRetries) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    baseTest.reportScreenshot("failedClick", "Failed to click");
                    throw new Exception(getCurrentTimeAndDate() + " Failed to click element: " + log);
                }
            }
        }
    }

    public void assertEQ(String actual, String expected, String log) {
        Assert.assertEquals(actual, expected);
        System.out.println(getCurrentTimeAndDate() + " Verified: " + log);
    }

    public void assertTrueDisplayed(WebElement element, String log) {
        Assert.assertTrue(element.isDisplayed());
        System.out.println(getCurrentTimeAndDate() + " Verified: " + log);
    }

    public String getCurrentTimeAndDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}