package selenium_core;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) throws Exception {
        DriverManager driverManager;
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME": {
                driverManager = new ChromeDriverManager();
            }
            break;
            case "FIREFOX": {
                driverManager = new FirefoxDriverManager();
            }

            case "EDGE": {
                driverManager = new EdgeDriverManager();
            }
            break;
            default:
                throw new Exception("Browser: " + browser + " is not supported!");
        }
        return driverManager;
    }
}