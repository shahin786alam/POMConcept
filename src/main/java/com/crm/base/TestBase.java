package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Shahin Alam\\eclipse-workspace\\POMConcept"
				+ "\\src\\main\\java\\com\\crm\\config\\config.properties");
		prop.load(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browsername.equals("FF")) {
			System.setProperty("webdriver.Gecko.driver", "C:\\Program Files\\Java\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}else if(browsername.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
