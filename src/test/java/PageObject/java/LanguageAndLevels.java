package PageObject.java;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtils;



public class LanguageAndLevels extends basepage{

	public LanguageAndLevels(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//*[@id='search-results-header-wrapper']/div/div[1]/div/div[3]/div[2]/button/span")
	 WebElement showMore;
	
	@FindBy(xpath = "//*[@id='checkbox-group']/div")
	public List<WebElement> Showlanguages;

	
	@FindBy(xpath = "//div[@class='css-1hllf5q']/button[1]")
	WebElement btn_apply;
	
	
	
	
	@FindBy(xpath= "//*[@data-testid='search-filter-group-Level']//div[1]/div[1]/div")
	 List<WebElement> countLevels;
	
	@FindBy(xpath = "//*[text()='Level']")
	WebElement scrollElement;
    
	public String levelElement = scrollElement.getText();
	public int  languagecount;

	
	public void btn_ShowMore() {
		showMore.click();
	}
	
	public void languageCount()
	{
	 
		int c=0;
		for(int i=0;i<Showlanguages.size();i++) {
			c++;
		}
		System.out.println(c);
		
	}
	public void lanuageDisplay() throws IOException {
		int r = 1;
		System.out.println("Languages :-");
		ExcelUtils.write("Language List", 0, 0,"Language Offered ");
		for (WebElement langString : Showlanguages) {
			System.out.println(langString.getText());
			ExcelUtils.write("Language List", r, 0, langString.getText());
			r++;
		}
		System.out.println("------------------------------------------------------------------");
	}
	public void ClickApply()
	{
		btn_apply.click();
	}
	
	public void displayLevels() throws InterruptedException, IOException
	{   int r = 1 ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",scrollElement );
		Thread.sleep(2000);
		System.out.println("Levels :-");
		ExcelUtils.write("Level List", 0, 0,"Level Offered ");
		for(WebElement level:countLevels)
		{
	        System.out.println(level.getText());
	        ExcelUtils.write("Level List", r, 0,level.getText());
	        r++;
		}
		System.out.println("-------------------------------------------------------------------------S");
		
	}
	
	
}
