package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    String url = "https://www.polovniautomobili.com/";

    String modalTitle;

    String expectedModalTitle = "Karoserije";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".paBlueButtonPrimary")
    WebElement consentCookie;

    @FindBy(css = "[title=' Sve marke']")
    WebElement brands;

    @FindBy(css = "[title=' Svi modeli']")
    WebElement models;

    @FindBy(css = "[title=' Godište od']")
    WebElement yearFrom;

    @FindBy(css = "[title=' do']")
    WebElement yearTo;

    @FindBy(css = ".sumo_year_to div ul li:nth-child(3) > label")
    WebElement selectedYearTo;

    @FindBy(css = "[title=' Karoserija']")
    WebElement chassis;

    @FindBy(css = ".sumo_chassis div ul li:nth-child(1) > span")
    WebElement chassisType;

    @FindBy(css = "[data-label='Pregled tooltipa - [Karoserija] - [Automobili]']")
    WebElement chassisTooltip;

    @FindBy(css = "#chassis_modal")
    WebElement chassisModal;

    @FindBy(css = "#chassis_modal h3")
    WebElement chassisModalTitle;

    @FindBy(css = "#chassis_modal div a")
    WebElement chassisModalCloseButton;

    @FindBy(css = "[title=' Gorivo']")
    WebElement fuel;

    @FindBy(css = ".sumo_fuel > div ul li:nth-child(2) span")
    WebElement fuelType;

    @FindBy(css = "[title=' Region']")
    WebElement regionSelect;

    @FindBy(css = "[title=' Polovna i nova vozila']")
    WebElement usedOrNew;

    @FindBy(css = "#credit")
    WebElement creditCheckbox;

    @FindBy(css = "[name='submit_1']")
    WebElement searchButton;

    public void acceptCookies() {
        consentCookie.click();
    }

    public void assertCorrectURL() {
        assertEQ(driver.getCurrentUrl(), url, "URL");
    }

    public void selectBrand(String brand) throws Exception {
        click(brands);
        click(driver.findElement(By.xpath("//label[text()='" + brand + "']")), "Car brand clicked: " + brand);
    }

    public void selectModel(String model) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=' Svi modeli']")));
        click(models);
        click(driver.findElement(By.xpath("//label[contains(text(),'" + model + "')]")), "Car model clicked: " + model);
    }

    public void enterPrice(String price) {
        driver.findElement(By.cssSelector("#price_to")).sendKeys(price);
    }

    public void selectYearFrom(String year) throws Exception {
        click(yearFrom);
        click(driver.findElement(By.xpath("//label[contains(text(),'" + year + "')]")), "Year from clicked: " + year);
    }

    public void selectYearTo() throws Exception {
        click(yearTo);
        click(selectedYearTo, "Year to clicked: " + selectedYearTo.getText());
    }

    public void selectChassisType() throws Exception {
        click(chassis);
        click(chassisType, "Chassis type has been clicked!");
    }

    public void checkChassisInfo() throws Exception {
        click(chassisTooltip);
        assertTrueDisplayed(chassisModal, "Modal displayed");
        modalTitle = chassisModalTitle.getText();
        assertEQ(modalTitle, expectedModalTitle, "Modal title");
        click(chassisModalCloseButton, "Modal has been closed!");
    }

    public void selectFuelType() throws Exception {
        click(fuel);
        click(fuelType, "Fuel type has been clicked!");
    }

    public void selectRegion(String region) throws Exception {
        click(regionSelect);
        click(driver.findElement(By.xpath("//label[text()='" + region + "']")), "Region clicked: " + region);
    }

    public void selectUsedOrNew(String usedOrNewCar) throws Exception {
        click(usedOrNew);
        click(driver.findElement(By.xpath("//label[text()='" + usedOrNewCar + "']")), "Used or new car clicked: " + usedOrNewCar);
    }

    public void checkCreditCheckbox() throws Exception {
        click(creditCheckbox, "Credit checkbox has been clicked");
    }

    public void clickSearchButton() throws Exception {
        click(searchButton, "Search button has been clicked!");
    }

    public void checkChosenCar(String selectedCar) {
        String searchTitle = driver.findElement(By.xpath("//span[contains(text(), '" + selectedCar + "')]")).getText();
        assertEQ(searchTitle, selectedCar, "Car brand and model");
    }
}
