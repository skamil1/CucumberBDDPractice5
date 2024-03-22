package com.bddCompany.steps;

import com.bddCompany.pages.XpathPractice;
import com.bddCompany.pages.cydeoPractice;
import com.bddCompany.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CydeoLogin {

    cydeoPractice cydeoPractice = new cydeoPractice();
    @Given("user selects the login tab")
    public void user_selects_the_login_tab() throws InterruptedException {
       cydeoPractice.LoginBtn.click();
       cydeoPractice.XClose.click();
    }

}
