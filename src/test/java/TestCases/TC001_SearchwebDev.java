package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import PageObject.java.Search_Web_Dev;
     
public class TC001_SearchwebDev extends baseclass{
     Search_Web_Dev S;
//     LanguageAndLevels L;
//     HomePage home_Page;
     
	 @Test(priority = 1, groups = {"sanity", "master"})
	void search_course() throws InterruptedException {
		 S = new Search_Web_Dev(driver);
		 Thread.sleep(1000);
		 Assert.assertEquals(driver.getTitle(), "Coursera | Degrees, Certificates, & Free Online Courses" );
		 logger.info(" Search ' WEB DEVELOPMENT ' Courses ");
		 S.searchCourse(p.getProperty("courseName"));
		
	 }
	 
	 @Test(priority = 2, groups = {"sanity","master"})
	 void SelectLanguageFilter() throws InterruptedException {
		
		 S.Select_Lang();
		 
		 logger.info(" Language seleted ");
	 }
	 
	 @Test(priority = 3, groups = {"sanity","master"})
	 void SelectLevelFilter() {
		 logger.info(" Level Selected ");
		 S.Select_Level();

	 }
	 
	 @Test(priority = 4,groups = {"sanity","master"})
	 void course_list() throws InterruptedException {
		 logger.info("Printing Course Data");
		 S.Course_names();
       
		 
	 }
	
	 
	 

}
