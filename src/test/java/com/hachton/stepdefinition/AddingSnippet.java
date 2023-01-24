package com.hachton.stepdefinition;

import com.hackton.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.time.LocalDateTime;

public class AddingSnippet {


    static final String ZAP_ADDRESS="localhost";
    static final int ZAP_PORT=8082;
    static final String ZAP_API="go2cuajavvpk1aopguphagevcq";

    private WebDriver driver;
    private ClientApi api;
//    @Before
//    public void setup(){
//        String proxyServerUrl=ZAP_ADDRESS+":"+ZAP_PORT;
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy(proxyServerUrl);
//        proxy.setSslProxy(proxyServerUrl);
//        FirefoxOptions firefoxOptions=new FirefoxOptions();
//        //firefoxOptions.setHeadless(true);
//        firefoxOptions.setAcceptInsecureCerts(true);
//        firefoxOptions.setProxy(proxy);
//        WebDriverManager.firefoxdriver().setup();
//        api=new ClientApi(ZAP_ADDRESS,ZAP_PORT,ZAP_API);
//        driver=new FirefoxDriver(firefoxOptions);
//    }


//    @After
//    public void tearDown() throws ClientApiException {
//        if (api != null){
//            String title="ZAP SECURITY REPORT";
//            String template="traditional-html";
//            String desc="This is security testing report";
//            LocalDateTime localDateTime= LocalDateTime.now();
//            String reportFileName="zap-security-"+localDateTime.toString()+".html";
//            String targetFolder= System.getProperty("user.dir");
//
//            ApiResponse generate = api.reports.generate(title, template, null, desc,
//                    null, null, null, null, null
//                    , reportFileName, null, targetFolder, null);
//
//            driver.quit();
//        }

  //  }


    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }


    @Given("Launch the google-gruyere application in firefox browser")
    public void launch_the_google_gruyere_application_in_firefox_browser() {
        driver.get("https://google-gruyere.appspot.com/554108174347637151437193920201762925485/");
        driver.findElement(LoginPage.signIn).click();
        driver.findElement(LoginPage.userId).sendKeys("breaking@gmail");
        driver.findElement(LoginPage.pwdText).sendKeys("Welcome@123");
        driver.findElement(LoginPage.loginBtn).click();
    }

    @When("Login to the application using valid username and password")
    public void login_to_the_application_using_valid_username_and_password() {
        System.out.println(driver.getTitle());
    }

    @When("Verify whether user is successfully logged in to the application")
    public void verify_whether_user_is_successfully_logged_in_to_the_application() {
        String homeText = driver.findElement(LoginPage.homeTxt).getText();
        Assert.assertTrue(homeText.equalsIgnoreCase("Gruyere: Home"));
    }

    @When("User is adding new snippet in the application")
    public void user_is_adding_new_snippet_in_the_application() {
//        driver.findElement(LoginPage.newSnippet).click();
//        driver.findElement(LoginPage.snippetBox).sendKeys("The security testing");
//        driver.findElement(LoginPage.submitBtn).click();
    }
}
