package tests;

import com.hitwe.objects.RegistrationPage;
import com.hitwe.objects.UserProfilePage;
import com.hitwe.utils.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RegistrationPageTest extends DriverSetup {
    RegistrationPage registrationPage;
    UserProfilePage userProfilePage;

    @BeforeMethod
    public void init() {
        registrationPage = new RegistrationPage ( getDriver () );
        userProfilePage = new UserProfilePage ( getDriver () );
    }

    @Test
    public void checkTheSuccessfulRegistrationAndUploadAvatar() {

        registrationPage
                .clickOnFemalePhoto ()
                .clickOnDarkLadiesButton ()
                .clickOnDarkEyeColorButton ()
                .clickOnCurvyButton ()
                .addTextToInputName ()
                .addTextToInputEmail ()
                .clickOnGenderSelect ()
                .chooseGenderValue ( "m" )
                .clickOnAgeSelect ()
                .chooseAgeValue ( "25" )
                .clickOnSignUpButton ();
        assertTrue ( userProfilePage.popupAppScreen.isDisplayed () );
        userProfilePage.clickCloseButton ();
        Assert.assertEquals ( registrationPage.userName, userProfilePage.profileName.getText () );
        Assert.assertEquals ( registrationPage.userName, userProfilePage.actPanelUserName.getText () );
        assertTrue ( userProfilePage.wait ( userProfilePage.avatarWithoutPhoto () ), "Element is not present" );
        userProfilePage.clickOnAvatar ();
        userProfilePage.uploadAvatar ();
        assertFalse ( userProfilePage.wait ( userProfilePage.avatarWithoutPhoto () ), "Element is present" );

    }
}

