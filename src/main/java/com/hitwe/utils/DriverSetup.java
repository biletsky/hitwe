package com.hitwe.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private static final String testURL = "https://hitwe.com/landing/inter2?p=15276";
    WebDriver driver;

    protected WebDriver getDriver() {

        driver.get ( testURL );
        return driver;

    }

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional("Firefox") String browser) throws Exception {

        if (browser.equalsIgnoreCase ( "firefox" )) {
            System.setProperty ( "webdriver.gecko.driver", ".\\geckodriver.exe" );
            driver = new FirefoxDriver ();
        } else if (browser.equalsIgnoreCase ( "chrome" )) {
            System.setProperty ( "webdriver.chrome.driver", ".\\chromedriver.exe" );
            driver = new ChromeDriver ();
        } else {
            throw new Exception ( "Browser is not correct" );
        }

        setPropertyWindow ();
        setPropertyTimeOut ();

    }

    public void setPropertyWindow() {

        driver.manage ().window ().maximize ();

    }

    public void setPropertyTimeOut() {

        driver.manage ().timeouts ().implicitlyWait ( 20, TimeUnit.SECONDS );

    }

    @AfterTest
    public void tearDown() {

        driver.quit ();

    }
}



