package com.bddCompany.steps;

import com.bddCompany.pages.XpathPractice;
import com.bddCompany.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class US01 {
    XpathPractice xpathPractice = new XpathPractice();
    Actions actions = new Actions(Driver.getDriver());
    @Given("as a user hover on {string} tab")
    public void as_a_user_hover_on_tab(String string) throws InterruptedException {
        actions.moveToElement(xpathPractice.xpathTab).build().perform();
        Thread.sleep(3000);

       Assert.assertEquals(string,xpathPractice.xpathTabName.getText() );
    }


    @Then("click on {string}")
    public void click_on(String string) throws InterruptedException {
        actions.moveToElement(xpathPractice.xpathTab).click().perform();
        Thread.sleep(3000);
    }
}
