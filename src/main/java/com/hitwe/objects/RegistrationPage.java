package com.hitwe.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationPage {

    public String userName = "Test";
    WebDriver driver;
    @FindBy(css = "[data-gender=m]")
    private WebElement male;
    @FindBy(css = "[data-gender=f]")
    private WebElement female;
    @FindBy(css = "#slide-02-f .left > a")
    private WebElement darkLadies;
    @FindBy(css = "#slide-03-f .left > a")
    private WebElement darkEyeColor;
    @FindBy(css = "#slide-04-f .left  a")
    private WebElement curvy;
    @FindBy(css = "[data-test=qa-name]")
    private WebElement name;
    @FindBy(css = "[data-test=qa-email]")
    private WebElement email;
    @FindBy(css = "[data-test=qa-gender]")
    private WebElement selectGender;
    @FindBy(css = "[data-test=qa-age]")
    private WebElement selectAge;
    @FindBy(css = "[data-test=qa-sign]")
    private WebElement signUp;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements ( driver, this );

    }

    public RegistrationPage clickOnFemalePhoto() {

        female.click ();
        return this;

    }

    public RegistrationPage clickOnDarkLadiesButton() {

        darkLadies.click ();
        return this;

    }

    public RegistrationPage clickOnDarkEyeColorButton() {

        darkEyeColor.click ();
        return this;

    }

    public RegistrationPage clickOnCurvyButton() {

        curvy.click ();
        return this;

    }

    public RegistrationPage addTextToInputName() {

        wait ( name );
        name.sendKeys ( userName );
        return this;

    }

    public RegistrationPage addTextToInputEmail() {

        Random randomGenerator = new Random ();
        int randomInt = randomGenerator.nextInt ( 1000 );
        email.sendKeys ( "testuser" + randomInt + "@testmail.com" );
        return this;

    }

    public RegistrationPage clickOnGenderSelect() {

        selectGender.click ();
        return this;

    }

    public RegistrationPage chooseGenderValue(String value) {

        String genderValue = String.format ( "//option[@value='%s']", value );
        driver.findElement ( By.xpath ( genderValue ) ).click ();
        return this;

    }

    public RegistrationPage clickOnAgeSelect() {

        selectAge.click ();
        return this;

    }

    public RegistrationPage chooseAgeValue(String value) {

        String ageValue = String.format ( "//option[@value='%s']", value );
        driver.findElement ( By.xpath ( ageValue ) ).click ();
        return this;

    }

    public RegistrationPage clickOnSignUpButton() {

        signUp.click ();
        return this;

    }

    public boolean wait(WebElement element) {

        try {

            (new WebDriverWait ( driver, 5 )).until ( ExpectedConditions.visibilityOf ( element ) );
            return true;

        } catch (org.openqa.selenium.NoSuchElementException e) {

            return false;

        }
    }

}
