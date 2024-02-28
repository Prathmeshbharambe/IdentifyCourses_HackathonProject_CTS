package PageObject.java;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.text.Utilities;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;
import bsh.ParseException;

public class Search_Web_Dev  extends basepage{
//	public  WebDriver driver;	
	
JavascriptExecutor js = (JavascriptExecutor)driver;;
        public String  parent_win ;
	public Search_Web_Dev(WebDriver driver) {
		super(driver);
		
	}
	
	
//	@FindBy(xpath = "//*[@id=\'rendered-content\']/div/header/div/div/div[2]/div[1]/div[3]/div/form/div/div[1]/input")
//	WebElement SearchBar;
	
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	WebElement searchBarElement;
	
	@FindBy (xpath = "//div/button[2]/div[@class='magnifier-wrapper']")
	WebElement btn_Search;
	
	@FindBy(xpath = "//*[@id='search-results-header-wrapper']/div/div[1]/div/div[3]/div[2]/button/span")
	 WebElement showMore;
	
	@FindBy(xpath = "//*[@id = 'checkbox-group']/div")
	WebElement englishLang ;
	
	
	@FindBy(xpath = "//div[@class='css-1hllf5q']/button[1]")
	WebElement btn_apply;
	
	@FindBy(xpath = "//label[contains(text(), 'Level')]/following-sibling::div/div[@data-testid = 'Beginner-false']//input")
	WebElement beginnerlevel;
	
	@FindBy(xpath = "//div/button/span[text()='Clear all']")
	WebElement scrollElement;
	
	
	
	@FindBy(xpath="//*[@class='cds-ProductCard-gridCard']")
	List<WebElement> courses ;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]")
	WebElement rating;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]")
	WebElement duration;
	
	@FindBy(xpath="//h3[normalize-space()='Filter by']")
	WebElement scrollEle3;
	
	@FindBy(xpath="//*[@data-e2e='hero-title']")
	public WebElement courseName;
	
	public void searchCourse(String CourseName) throws InterruptedException {

		//	   searchBarElement.click();
//		   Thread.sleep(1000);
		   searchBarElement.sendKeys(CourseName);
		   Thread.sleep(1000);
		   btn_Search.click();
		}
		
		
		public void Select_Lang() throws InterruptedException {
			showMore.click();
			Thread.sleep(1000);
			englishLang.click();
			
			btn_apply.click();
		}

		public void Select_Level() {
			beginnerlevel.click();
		}
		
	//extract the course names, total learning hours & rating for first 2 courses
	
	public void Course_names() throws InterruptedException {
		
		js.executeScript("arguments[0].scrollIntoView();", scrollElement);

		 String  parent_win = driver.getWindowHandle();	
		for (int i = 0 ; i<2;i++) {
			
			courses.get(i).click();
		}
		Set<String> windowSet =driver.getWindowHandles();
	  int r = 0;
	  
		for(String win:windowSet) {
			if(win.equals(parent_win)) {
				continue;
			}
			
			driver.switchTo().window(win);
			try {
				 	System.out.println("Course Name is : "+courseName.getText());
				    System.out.println("Course Rating is : "+rating.getText());
				  ExcelUtils.write("Course Details", r, 0,"Course Details");
				  ExcelUtils.write("Course Details",r+1 , 0, courseName.getText());
				  ExcelUtils.write("Course Details", r+2, 0 , rating.getText());
				    String hrs = duration.getText();
				    String[] parts = hrs.split(" ");
				    int months = Integer.parseInt(parts[0]);
				    int hoursPerWeek = Integer.parseInt(parts[3]);
				    int totalLearningHrs = months*4*hoursPerWeek;  //4 weeks per month
				    System.out.println("Total Learning hours : "+totalLearningHrs);
				    ExcelUtils.write("Course Details", r+3, 0, String.valueOf(totalLearningHrs));
				    System.out.println("------------------------------------------------------------------");
				    r+=4;
			} catch (Exception e) {
				System.out.println("Error :- "+ e.getMessage());
			}
			
			
		}
		driver.switchTo().window(parent_win);
	}
	  
	
	
}
