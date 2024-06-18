package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.HomePage;
import tests.BaseTest;

public class MainSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("I am on the polovni automobili home page and I accept cookies")
    public void iAmOnThePolovniAutomobiliHomePageAndIAcceptCookies() throws Exception {
        openApp(env);
        new HomePage(driver).acceptCookies();
        new HomePage(driver).assertCorrectURL();
    }

    @When("I select brand {string}")
    public void iSelectBrand(String brand) throws Exception {
        new HomePage(driver).selectBrand(brand);
    }

    @And("I select model {string}")
    public void iSelectModel(String model) throws Exception {
        new HomePage(driver).selectModel(model);
    }

    @And("I enter price up to {string} euros")
    public void iEnterPriceUpToEuros(String price) {
        new HomePage(driver).enterPrice(price);
    }

    @And("I select year from {string}")
    public void iSelectYearFrom(String year) throws Exception {
        new HomePage(driver).selectYearFrom(year);
    }

    @And("I select year to")
    public void iSelectYearTo() throws Exception {
        new HomePage(driver).selectYearTo();
    }

    @And("I select chassis type")
    public void iSelectChassisType() throws Exception {
        new HomePage(driver).selectChassisType();
    }

    @And("I check and verify chassis modal info")
    public void iCheckAndVerifyChassisModalInfo() throws Exception {
        new HomePage(driver).checkChassisInfo();
    }

    @And("I select fuel type")
    public void iSelectFuelType() throws Exception {
        new HomePage(driver).selectFuelType();
    }

    @And("I select region {string}")
    public void iSelectRegion(String region) throws Exception {
        new HomePage(driver).selectRegion(region);
    }

    @And("I select option {string}")
    public void iSelectOption(String usedOrNewCar) throws Exception {
        new HomePage(driver).selectUsedOrNew(usedOrNewCar);
    }

    @And("I click on the credit checkbox")
    public void iClickOnTheCreditCheckbox() throws Exception {
        new HomePage(driver).checkCreditCheckbox();
    }


    @And("I click on the search button")
    public void iClickOnTheSearchButton() throws Exception {
        new HomePage(driver).clickSearchButton();
    }

    @Then("I should be able to see results page for selected car {string}")
    public void iShouldBeAbleToSeeResultsPageForSelectedCar(String selectedCar) {
        new HomePage(driver).checkChosenCar(selectedCar);
    }
}
