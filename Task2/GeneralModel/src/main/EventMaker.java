package main;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EventMaker{
	 protected Request_maker rm;
	 WebDriver driver;
	
	 public EventMaker(){
		 rm = new Request_maker();
		 System.setProperty("webdriver.chrome.driver","/Users/miche/Desktop/school/year 3/software testing/Tutorial/chromedriver/chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.marketalertum.com/");
	     
	 }
	 
	 public void create_alert(){
	        Alert my_alert= new Alert(123,"title","descr",5,"link","img");
	        rm.makePostRequest(my_alert);
	 }
	 
	 public void delete_alerts(){
		 rm.makeDeleteRequest();
	 }
	 
	 public void log_in(){
		 String valid_id="73ed1cab-f8c2-4ff8-84b6-d7f81d835829";
		 driver.findElement(By.xpath("//a[@href='/Alerts/Login']")).click();
	     WebElement input_text = driver.findElement(By.id("UserId"));
	     input_text.sendKeys(valid_id);
	     input_text.sendKeys(Keys.ENTER);
	 }
	 
	 public void log_out(){
		 driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
	 }
	 
	 public void view_alerts(){
		 driver.findElement(By.xpath("//a[@href='/Alerts/List']")).click();
	 }
	 
	 public void close_driver(){
		 driver.close();
	 }
}