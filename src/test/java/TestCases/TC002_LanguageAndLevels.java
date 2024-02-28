package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import PageObject.java.HomePage;
import PageObject.java.LanguageAndLevels;

public class TC002_LanguageAndLevels extends baseclass{
	LanguageAndLevels L;
   
	
	 	
	 @Test(priority = 5,groups = {"sanity","master"})
	 void Languagecount() throws InterruptedException, IOException {
		L = new LanguageAndLevels(driver);
		Thread.sleep(3000);
		
		
		L.btn_ShowMore();
		
		logger.info("Language count");
		 L.languageCount();
		
		 logger.info("Language list got printed ");
		 L.lanuageDisplay();
	 }
	 
	 @Test(priority = 6,groups = {"sanity","master"})
	 void ClickOnApply() throws InterruptedException {
		 
		 Thread.sleep(1000);
		 logger.info("Click On Apply Button ");
		 L.ClickApply();
		 
	 } 
	 
	 
	 @Test(priority = 7,groups = {"sanity","master"})
	 void Levels() throws InterruptedException, IOException {
		 logger.info("Level list got printed ");
	
		 L.displayLevels();
		 

	 }
}
