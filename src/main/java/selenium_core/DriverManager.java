package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    public abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}