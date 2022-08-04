package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;


public class RegistrationStepDefinitions {

    // All relevant locators and methods are related to the Register module of this website
    @Autowired
    private BrowserContext browserContext;

    @Given("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        browserContext.pauseForDebug();
    }

    @When("the user clicks on the registration section")
    public void theUserClicksOnTheRegistrationSection() {
        browserContext.getDriver().findElement(By.xpath("//a[text()='Register']")).click();
        browserContext.pauseForDebug();
    }

    @And("the user inputs valid username {string} and password {string}")
    public void theUserInputsValidUsernameAndPassword(String username, String password) {
        browserContext.getDriver().findElement(By.id("UserName")).sendKeys(username);
        browserContext.getDriver().findElement(By.id("Password")).sendKeys(password);
        browserContext.getDriver().findElement(By.id("PasswordReEnter")).sendKeys(password);
        browserContext.getDriver().findElement(By.id("RegisterButton")).click();
        browserContext.pauseForDebug();
    }

    @Then("the user will be directed to the login page")
    public void theUserWillBeDirectedToTheLoginPage() {
        String title = browserContext.getDriver().getTitle();
        assertTrue(title.contains("Login"));
    }

    @And("the user inputs less than four characters for the password")
    public void theUserInputsLessThanFourCharactersForThePassword() throws InterruptedException {
        browserContext.getDriver().findElement(By.id("UserName")).sendKeys("mike");
        Thread.sleep(2000);
        browserContext.getDriver().findElement(By.id("Password")).sendKeys("007");
        Thread.sleep(2000);
        browserContext.getDriver().findElement(By.id("PasswordReEnter")).sendKeys("007");
        Thread.sleep(2000);
        browserContext.getDriver().findElement(By.id("RegisterButton")).click();
        Thread.sleep(3000);
    }

    @Then("the user verifies that an error message appears")
    public void theUserVerifiesThatAnErrorMessageAppears() {
        WebElement errorMessage = browserContext.getDriver().findElement(By.id("ErrorMessage"));
        System.out.println(errorMessage.getText());
        assertTrue(errorMessage.isDisplayed());
    }


}