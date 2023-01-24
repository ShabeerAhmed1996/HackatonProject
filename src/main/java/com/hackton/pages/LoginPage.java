package com.hackton.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By signIn=By.xpath("//*[contains(text(),'Sign in')]");
    public static final By userId=By.xpath("//*[@name='uid']");
    public static final By pwdText=By.xpath("//*[@name='pw']");
    public static final By loginBtn=By.xpath("//*[@value='Login']");

    public static final By homeTxt=By.xpath("//h2[contains(text(),'Gruyere: Home')]");
    public static final By newSnippet=By.xpath("//*[contains(text(),'Upload')]//preceding::a[1]");
    public static final By snippetBox=By.xpath("//*[@name='snippet']");
    public static final By submitBtn =By.xpath("//*[@value='Submit']");


   



}
