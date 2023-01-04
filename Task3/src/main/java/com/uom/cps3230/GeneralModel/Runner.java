package com.uom.cps3230.GeneralModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {

    private int current_event;
    boolean loggedIn =false;
    protected Request_maker rm;
    WebDriver driver;

    public int getCurrent_event() {
        return current_event;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Runner(){
        rm = new Request_maker();
        System.setProperty("webdriver.chrome.driver","/Users/miche/Desktop/school/year 3/software testing/Tutorial/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");

    }

    public void create_alert(){
        Alert my_alert= new Alert(123,"title","descr",5,"link","img");
        rm.makePostRequest(my_alert);
        current_event = 0;
    }

    public void delete_alerts(){
        rm.makeDeleteRequest();
        current_event = 1;
    }

    public void log_in(){
        String valid_id="73ed1cab-f8c2-4ff8-84b6-d7f81d835829";
        driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();
        WebElement input_text = driver.findElement(By.id("UserId"));
        input_text.sendKeys(valid_id);
        input_text.sendKeys(Keys.ENTER);

        current_event = 5;
        loggedIn= true;
    }

    public void log_out(){
        //driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
        current_event = 6;
        loggedIn = false;
    }

    public void view_alerts(){
        driver.findElement(By.xpath("//a[@href='/Alerts/List']")).click();

        current_event = 7;
    }

    public void close_driver(){
        driver.close();
    }
}
