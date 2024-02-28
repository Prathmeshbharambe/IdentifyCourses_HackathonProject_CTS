package Cucumber;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	static Logger logger ;
	static Properties p ; 
	
	@BeforeAll
    public static void setup() throws IOException
    {
    	
    	driver = new ChromeDriver();
		//Loading property file
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
		logger= LogManager.getLogger();
    			
	}
		
    
    @AfterAll
    public static void tearDown() {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
         
      
    }
     public static WebDriver getDriver() {
		return driver;
	}
     public static Logger getLogger() {
		return logger;
	}
      public static Properties getP() {
		return p;
      }
}
