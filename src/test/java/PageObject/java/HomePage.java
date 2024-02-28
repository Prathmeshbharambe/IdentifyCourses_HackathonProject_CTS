package PageObject.java;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtils;

public class HomePage extends basepage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//div[@class='m-a-0 body']")
	WebElement home;
	
	@FindBy(xpath="//a[text()='For Enterprise']")
	 WebElement ClickonForEnterprise;
	
	@FindBy(xpath = "//a[text()='Solutions']")
	WebElement ClickOnSolutions;
	
	@FindBy(xpath="//p[text()='Coursera for Campus']")
	 WebElement ForCampus;
	
	@FindBy(xpath="//input[@id='FirstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@id='Email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='Phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement Company;
	
	@FindBy(xpath = "//select[@id='Institution_Type__c']")
	WebElement dropdown1;
	
	@FindBy(xpath = "//select[@id='Title']")
	WebElement dropdown2;
	
	@FindBy(xpath = "//select[@id='Department']")
	WebElement dropdown3;
	
	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']")
	WebElement dropdown4;
	
	@FindBy(xpath = "//select[@id='Country']")
	WebElement dropdown5;
	
	@FindBy(xpath = "//span[@class='mktoButtonWrap mktoRound']")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	WebElement Error;
	
	public String exp_error = "Must be valid email.\n"
			+ "example@yourdomain.com";
	
	// click on "COURSEERA" to go at home page
		public void HoverHomePage()
		{
			home.click();
		}
		
		
		public void forEnterprise() throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	 		js.executeScript("arguments[0].scrollIntoView();",ClickonForEnterprise );
	 		Thread.sleep(2000);
	 		
	 		js.executeScript("arguments[0].click();",ClickonForEnterprise );
		//	ClickonForEnterprise.click();
		}
		
		public void solutionClick()
		{
			ClickOnSolutions.click();
		}
		
		public void CoursesForCampus()
		{
			ForCampus.click();
		}
		
		public void FillForm1(String firstname, String Lastname, String EMAIL, String PHONE, String COMPANY)
		{
			firstName.sendKeys(firstname);
			lastName.sendKeys(Lastname);
			email.sendKeys(EMAIL);
			phone.sendKeys(PHONE);
			Company.sendKeys(COMPANY);
			
		}
		
		public void InstituteType()
		{
			Select select = new Select(dropdown1);
			select.selectByVisibleText("University/4 Year College");
		}
		
		public void JobRole()
		{
			Select select = new Select(dropdown2);
			select.selectByVisibleText("Student");
		}
		
		public void Department()
		{
			Select select  = new Select(dropdown3);
			select.selectByVisibleText("Student Affairs");
		}
		
		public void WhichRoleDescribeYou()
		{
			Select select = new Select(dropdown4);
			select.selectByVisibleText("Tech Support");
		}
		
		public void country()
		{
			Select select = new Select(dropdown5);
			select.selectByVisibleText("India");
		}
		
		public void button()
		{
			SubmitButton.click();
		}
		
		public String ErrorMessage() throws IOException
		{
			System.out.println();
			String errormsg = Error.getText();
			ExcelUtils.write("Error Message", 0, 0, errormsg);
			System.out.println(errormsg);
			return errormsg;
		}
}
