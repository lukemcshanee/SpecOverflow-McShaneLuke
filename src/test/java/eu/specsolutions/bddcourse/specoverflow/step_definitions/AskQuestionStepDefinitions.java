package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class AskQuestionStepDefinitions {

    // All relevant locators and methods are related to the Ask Question part of this website
    @Autowired
    private BrowserContext browserContext;

    @When("the user clicks on ask question section")
    public void theUserClicksOnAskQuestionSection() {
        browserContext.getDriver().findElement(By.linkText("Ask Question")).click();
        browserContext.pauseForDebug();
    }

    @And("the user completes the ask a question section")
    public void theUserCompletesTheAskAQuestionSection() {
        browserContext.getDriver().findElement(By.id("TitleInput")).sendKeys("What are the locators in Selenium?");
        browserContext.pauseForDebug();
        browserContext.getDriver().findElement(By.id("BodyInput")).sendKeys("Id, name, className, tagName, Css, Xpath");
        browserContext.pauseForDebug();
        browserContext.getDriver().findElement(By.id("Tags")).sendKeys("locators");
        browserContext.pauseForDebug();
        browserContext.getDriver().findElement(By.id("PostQuestionButton")).click();
        browserContext.pauseForDebug();
    }

    @Then("a warning message appears")
    public void aWarningMessageAppears() {
        String warningMessage = browserContext.getDriver().findElement(By.id("ErrorMessage")).getText();
        System.out.println("warningMessage = " + warningMessage);
        assertTrue(browserContext.getDriver().findElement(By.id("ErrorMessage")).isDisplayed());
    }

    @When("the user is logged in")
    public void theUserIsLoggedIn() {
        browserContext.getDriver().findElement(By.xpath("//a[text()='[Default Login]']")).click();
        browserContext.pauseForDebug();
    }

    @Then("a {string} message appears")
    public void aMessageAppears(String expectedMessage) {
        String actualMessage = browserContext.getDriver().findElement(By.id("QuestionTitle")).getText();
        assertEquals(actualMessage, expectedMessage);
    }
}