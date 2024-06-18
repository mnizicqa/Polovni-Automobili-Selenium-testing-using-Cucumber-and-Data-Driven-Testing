package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;
    String path = "results/screenshots/";

    public void init(String browser, String wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(wait)));
    }

    public void quit() {
        driverManager.quitDriver();
    }

    public void openApp(String env) throws Exception {
        env = env.toUpperCase();
        switch (env) {
            case "LOCAL": {
                driver.get("127.0.0.1");
            }
            break;
            case "DEV": {
                driver.get("https://www.dev.polovniautomobili.com/");
            }
            break;
            case "QA": {
                driver.get("https://www.qa.polovniautomobili.com/");
            }
            break;
            case "UAT": {
                driver.get("https://www.uat.polovniautomobili.com/");
            }
            break;
            case "PROD": {
                driver.get("https://www.polovniautomobili.com/");
            }
            break;
            default:
                throw new Exception("Environment: " + env + " is not supported!");
        }
    }

    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path + fileName + ".png"));
    }

    public void reportScreenshot(String fileName, String description) throws IOException {
        takeScreenshot(fileName);
        Path content = Paths.get(path + fileName + ".png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(description, is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}