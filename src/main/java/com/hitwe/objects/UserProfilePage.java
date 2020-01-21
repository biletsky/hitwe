package com.hitwe.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class UserProfilePage {

    @FindBy(css = ".prof-name")
    public WebElement profileName;
    @FindBy(css = ".act-panel-user-name")
    public WebElement actPanelUserName;
    @FindBy(css = ".interstial-app-screen")
    public WebElement popupAppScreen;
    WebDriver driver;
    @FindBy(css = "a.interstial-close")
    private WebElement closePopup;
    @FindBy(css = "input[type=file]")
    private WebElement file;
    @FindBy(css = "[do-click=photoUploadClick]")
    private WebElement submitFile;
    @FindBy(css = ".prof-ava > .prof_add_avatar")
    private WebElement addAvatar;
    @FindBy(css = ".prof-ava .avatar-placeholder.no-photo")
    private WebElement avatarWithoutPhoto;
    @FindBy(css = ".user-avatar > div[style*='display: none']")
    private WebElement loading;

    public UserProfilePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements ( driver, this );

    }

    public UserProfilePage clickCloseButton() {

        closePopup.click ();
        return this;

    }

    public UserProfilePage clickOnAvatar() {

        wait ( addAvatar );
        addAvatar.click ();
        return this;

    }

    public UserProfilePage uploadAvatar() {

        File myfile = new File ( "src/main/resources/file.png" );
        file.sendKeys ( myfile.getAbsolutePath () );
        submitFile.submit ();
        wait ( loading );
        return this;

    }

    public boolean wait(WebElement element) {

        try {
            (new WebDriverWait ( driver, 5 )).until ( ExpectedConditions.visibilityOf ( element ) );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public WebElement avatarWithoutPhoto() {

        return avatarWithoutPhoto;

    }

}
