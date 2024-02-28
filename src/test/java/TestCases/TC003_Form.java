package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseclass;
import PageObject.java.HomePage;

public class TC003_Form extends baseclass{
	 HomePage home_Page;
	 @Test(priority = 8,groups = {"sanity","regression","master"})
	 void HomePage() throws InterruptedException {
		 home_Page = new HomePage(driver);
		 logger.info("Clicked On 'COURSERA' ");
		 home_Page.HoverHomePage();
		 
	 }
	 
	 @Test(priority = 9,groups = {"sanity","regression","master"})
	 void ForEnterprise() throws InterruptedException {
		 System.out.println("successfully clicked on 'COURSEERA'");
		 logger.info(" Clicked  on 'FOR ENTERPRISE' ");
		 home_Page.forEnterprise();
		 System.out.println("successfully clicked  on 'FOR ENTERPRISE'");
	 }
	 
	 @Test(priority =  10,groups = {"sanity","regression","master"})
	 void Solutions() throws InterruptedException {
		 Thread.sleep(1000);
		 logger.info("Clicked On Solutions ");
		home_Page.solutionClick();

		System.out.println("successfully clicked on 'SOLUTION'");
	 }
	 
	 
	 @Test(priority =  11,groups = {"sanity","regression","master"})
	 void ForCampus() throws InterruptedException 
	 {
		Thread.sleep(2000);
		logger.info("Clicked on 'COURSES FOR CAMPUS' ");
		home_Page.CoursesForCampus();

		System.out.println("successfully clicked on 'COURSES FOR CAMPUS' ");
	 }
	 
	 @Test(priority = 12,groups = {"regression","master"})
	 void Form() {
		 Assert.assertEquals(driver.getTitle(), "Online Learning Platform for Universities | Coursera");
		home_Page.FillForm1(p.getProperty("FirstName"), p.getProperty("LastName"),p.getProperty("EmailId"), p.getProperty("ContactNo"), p.getProperty("InstituteName"));

		home_Page.InstituteType();
		home_Page.JobRole();
		home_Page.Department();
		home_Page.WhichRoleDescribeYou();
		home_Page.country();
		logger.info("form got filled  ");
	 }
	 
	 @Test(priority = 13,groups = {"regression","master"})
	 void FormSubmit() {
		 logger.info("Error Message Occur ");
		 home_Page.button();

	 }
	 
	 @Test(priority = 14, groups = {"regression","master"})
	 void CaptureError() throws IOException {
		 System.out.println("Error Message");

		 Assert.assertEquals(home_Page.ErrorMessage(), home_Page.exp_error);
	 }
	 
}
