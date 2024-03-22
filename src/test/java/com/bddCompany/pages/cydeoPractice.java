package com.bddCompany.pages;

import com.bddCompany.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cydeoPractice {

    public cydeoPractice(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text() =\"Log In\"]")
    public WebElement LoginBtn;

    @FindBy(xpath = "//button[@class=\"pum-close popmake-close\"]")
    public WebElement XClose;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "action")
    public WebElement ContinueBtn;



}
