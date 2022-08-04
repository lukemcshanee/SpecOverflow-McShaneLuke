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

import java.util.ArrayList;
import java.util.List;

public class VotingAnswersStepDefinitions {

    // All relevant locators and methods are related to the Questions' section of this website
    @Autowired
    private BrowserContext browserContext;

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        browserContext.pauseForDebug();
    }

    @When("the user clicks on the questions section")
    public void theUserClicksOnTheQuestionsSection() {
        browserContext.getDriver().findElement(By.xpath("//a[text()='Questions']")).click();
        browserContext.pauseForDebug();
    }

    @Then("the user verifies that questions are listed in descending order")
    public void theUserVerifiesThatQuestionsAreListedInDescendingOrder() {
        List<String> counts = new ArrayList<String>();
        List<WebElement> allCounts = browserContext.getDriver().findElements(By.xpath("//div[@class='votes count']//span"));
        for (WebElement c : allCounts) {
            counts.add(c.getText());
        }
        int firstVote = Integer.parseInt(counts.get(0));
        int lastVote = Integer.parseInt(counts.get(counts.size() - 1));
        System.out.println("firstVote = " + firstVote);
        System.out.println("lastVote = " + lastVote);
        assertTrue(lastVote > firstVote);
    }

    @And("the user clicks on the first question")
    public void theUserClicksOnTheFirstQuestion() {
        browserContext.getDriver().findElement(By.xpath("//a[text()='What is Cucumber?']")).click();
        browserContext.pauseForDebug();
    }

    @And("the user clicks on the vote up button")
    public void theUserClicksOnTheVoteUpButton() {
        browserContext.getDriver().findElement(By.cssSelector("div > button > svg > path[d='M2 26h32L18 10 2 26z']")).click();
        browserContext.pauseForDebug();
    }

    @Then("the user is verified, a pop-up message appears")
    public void theUserIsVerifiedAPopUpMessageAppears() {
        String popUpMessage = browserContext.getDriver().switchTo().alert().getText();
        System.out.println("popUpMessage = " + popUpMessage);
        //assertFalse(popUpMessage.isEmpty());
        assertTrue(popUpMessage.contains("login"));
    }
}


