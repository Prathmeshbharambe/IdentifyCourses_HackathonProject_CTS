package Cucumber;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import PageObject.java.HomePage;
import PageObject.java.LanguageAndLevels;
import PageObject.java.Search_Web_Dev;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	static WebDriver driver;
	static Logger logger ;
	static Properties p ; 
	Search_Web_Dev S;
	LanguageAndLevels L;
	HomePage home_Page;

	@Given("launched the browser and open url")
	public void launched_the_browser_and_open_url() throws IOException {
		driver=Hooks.getDriver();
		logger= Hooks.getLogger();
		p=Hooks.getP();
		logger.info("****************** Driver Launch **********************");
		driver.get(p.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@When("search Course")
	public void search_course() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		S = new Search_Web_Dev(driver);
		 Thread.sleep(1000);
		 Assert.assertEquals(driver.getTitle(), "Coursera | Degrees, Certificates, & Free Online Courses" );
		 logger.info(" Search ' WEB DEVELOPMENT ' Courses ");
		 S.searchCourse(p.getProperty("courseName"));
	}

	@When("select language")
	public void select_language() throws InterruptedException {
		S.Select_Lang();
		 
		 logger.info(" Language seleted ");
	}
	@When("select level")
	public void select_level() {
		logger.info(" Level Selected ");
		 S.Select_Level();
	}

	@Then("Getting data of courses")
	public void getting_data_of_courses() throws InterruptedException {
		logger.info("Printing Course Data");
		 S.Course_names();
	}

	@Given("Gettig the list of languages")
	public void gettig_the_list_of_languages() throws InterruptedException, IOException {
		L = new LanguageAndLevels(driver);
		Thread.sleep(3000);
		
		
		L.btn_ShowMore();
		
		logger.info("Language count");
		 L.languageCount();
		
		 logger.info("Language list got printed ");
		 L.lanuageDisplay();
	}

	@When("Click on apply button")
	public void click_on_apply_button() throws InterruptedException {
		 Thread.sleep(1000);
		 logger.info("Click On Apply Button ");
		 L.ClickApply();
	}

	@Then("getting list of levels")
	public void getting_list_of_levels() throws InterruptedException, IOException {
		logger.info("Level list got printed ");
		
		 L.displayLevels();
		
	}

	@Given("get back to home page")
	public void get_back_to_home_page() {
		home_Page = new HomePage(driver);
		 logger.info("Clicked On 'COURSERA' ");
		 home_Page.HoverHomePage();
	}

	@When("Click on For Enterprises")
	public void click_on_for_enterprises() throws InterruptedException {
		 System.out.println("successfully clicked on 'COURSEERA'");
		 logger.info(" Clicked  on 'FOR ENTERPRISE' ");
		 home_Page.forEnterprise();
		 System.out.println("successfully clicked  on 'FOR ENTERPRISE'");
	}

	@When("Click on Soltions")
	public void click_on_soltions() throws InterruptedException {
		Thread.sleep(1000);
		 logger.info("Clicked On Solutions ");
		home_Page.solutionClick();
		System.out.println("successfully clicked on 'SOLUTION'");
	}

	@When("Click on For Campus")
	public void click_on_for_campus() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("Clicked on 'COURSES FOR CAMPUS' ");
		home_Page.CoursesForCampus();

		System.out.println("successfully clicked on 'COURSES FOR CAMPUS' ");
	}

	@When("Fill the form")
	public void fill_the_form() {
		Assert.assertEquals(driver.getTitle(), "Online Learning Platform for Universities | Coursera");
		home_Page.FillForm1(p.getProperty("FirstName"), p.getProperty("LastName"),p.getProperty("EmailId"), p.getProperty("ContactNo"), p.getProperty("InstituteName"));

		home_Page.InstituteType();
		home_Page.JobRole();
		home_Page.Department();
		home_Page.WhichRoleDescribeYou();
		home_Page.country();
		logger.info("form got filled  ");
	}

	@When("Submit the form")
	public void submit_the_form() {
		logger.info("Error Message Occur ");
		 home_Page.button();
	}

	@Then("Capture the Error Message")
	public void capture_the_error_message() throws IOException {
		
		 System.out.println("Error Message");
		 Assert.assertEquals(home_Page.ErrorMessage(), home_Page.exp_error);
	}
    

}
