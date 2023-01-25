package com.hachton.stepdefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public class ZappingTest {

    static final String ZAP_ADDRESS="localhost";
    static final int ZAP_PORT=8082;
    static final String ZAP_API="go2cuajavvpk1aopguphagevcq";

    private WebDriver driver;
    private ClientApi api;

    @BeforeMethod
    public void setup(){
        String proxyServerUrl=ZAP_ADDRESS+":"+ZAP_PORT;
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyServerUrl);
        proxy.setSslProxy(proxyServerUrl);
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setHeadless(true);
        firefoxOptions.setProxy(proxy);
        WebDriverManager.firefoxdriver().setup();
        api=new ClientApi(ZAP_ADDRESS,ZAP_PORT,ZAP_API);
        driver=new FirefoxDriver(firefoxOptions);
    }

    @Test
    public void hacktonTest(){
      driver.get("https://google-gruyere.appspot.com/554108174347637151437193920201762925485/");
      driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
      driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("breaking@gmail");
      driver.findElement(By.xpath("//*[@name='pw']")).sendKeys("Welcome@123");
      driver.findElement(By.xpath("//*[@value='Login']")).click();

      System.out.println(driver.getTitle());
      String homeText = driver.findElement(By.xpath("//h2[contains(text(),'Gruyere: Home')]")).getText();
      Assert.assertTrue(homeText.equalsIgnoreCase("Gruyere: Home"));

      driver.findElement(By.xpath("//*[contains(text(),'Upload')]//preceding::a[1]")).click();
      driver.findElement(By.xpath("//*[@name='snippet']")).sendKeys("The security testing");
      driver.findElement(By.xpath("//*[@value='Submit']")).click();



    }

    @AfterMethod
    public void tearDown() throws ClientApiException {
        if (api != null){
            String title="ZAP SECURITY REPORT";
            String template="traditional-html";
            String desc="This is security testing report";
            String reportFileName="zap-security03.html";
            String targetFolder= System.getProperty("user.dir");

            ApiResponse generate = api.reports.generate(title, template, null, desc,
                    null, null, null, null, null
                    , reportFileName, null, targetFolder, null);

            driver.quit();
        }
    }




}
