package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login{
	String valid_id="73ed1cab-f8c2-4ff8-84b6-d7f81d835829";
    String invalid_id="73ed1cab-f8c2";
    
    WebDriver driver;
    
    public Login(){
    	System.setProperty("webdriver.chrome.driver","/Users/miche/Desktop/school/year 3/software testing/Tutorial/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    public void go_to_website(){
    	driver.get("https://www.marketalertum.com/");
    }
    
    
    public void valid_login(){
        driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();

        WebElement input_text = driver.findElement(By.id("UserId"));
        input_text.sendKeys(valid_id);

        input_text.sendKeys(Keys.ENTER);
    }
    
    public void invalid_login() {
        driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();

        WebElement input_text = driver.findElement(By.id("UserId"));
        input_text.sendKeys(invalid_id);

        input_text.sendKeys(Keys.ENTER);
    }
    
    public void log_out(){
    	driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
    	
    }
    
    public void close_driver(){
    	driver.close();
    }
	
}