package com.uom.cps3230.LoginModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginRunner {


    String valid_id="73ed1cab-f8c2-4ff8-84b6-d7f81d835829";
    String invalid_id="73ed1cab-f8c2";

    WebDriver driver;

    boolean is_logged = false;
    public LoginRunner(){
        System.setProperty("webdriver.chrome.driver","/Users/miche/Desktop/school/year 3/software testing/Tutorial/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
    }

    public boolean is_logged() {
        return is_logged;
    }

    public void login () throws IOException {
        driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();

        WebElement input_text = driver.findElement(By.id("UserId"));
        input_text.sendKeys(valid_id);

        input_text.sendKeys(Keys.ENTER);

        set_is_loggedin();
    }

    public void logout() throws IOException {
        driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
        set_is_loggedin();
    }

    public void invalid_login() throws IOException {
        driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();

        WebElement input_text = driver.findElement(By.id("UserId"));
        input_text.sendKeys(invalid_id);

        input_text.sendKeys(Keys.ENTER);
        set_is_loggedin();
    }



    public void set_is_loggedin() throws JSONException, IOException {
        Request_maker rm= new Request_maker();
        String login = rm.makeLoginGetRequest();

        JSONObject my_obj = new JSONObject(login);

        boolean status = my_obj.getBoolean("isLoggedInOnWebsite");
        is_logged = status;
    }


}
