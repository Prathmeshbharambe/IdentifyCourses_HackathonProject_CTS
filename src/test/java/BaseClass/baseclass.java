package BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseclass {
      
    public static WebDriver driver;
  	public static Logger logger;
  	public static  Properties p;
  	@BeforeTest(groups = {"sanity","regression","master"})
  	@Parameters({"browser","os"})
	 public void Setup(String browser,String os) throws InterruptedException, IOException {
  		
//  		if(br.equalsIgnoreCase("Chrome"))
//		{
//			driver=new ChromeDriver(); 
//		}
//		else if(br.equalsIgnoreCase("Edge")) 
//		{
//			driver=new EdgeDriver(); 
//		}
  		
		//Loading property file
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			logger= LogManager.getLogger(this.getClass());
   //Disabling the notifications
			ChromeOptions c_option = new ChromeOptions();
			c_option.addArguments("disable-notifications");
			EdgeOptions e_option = new EdgeOptions();
			e_option.addArguments("disable-notifications");

			//new code - 
			if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabalities = new DesiredCapabilities();
				if(os.equalsIgnoreCase("windows")) {
					capabalities.setPlatform(Platform.WIN11);
				}
				else if (os.equalsIgnoreCase("mac")) {
					capabalities.setPlatform(Platform.MAC);
				}
				else {
					System.out.println("no matching os .....");
					return ;
				}
				//browser
				if(browser.equalsIgnoreCase("chrome")) {
					capabalities.setBrowserName("chrome");
				}
				else if(browser.equalsIgnoreCase("edge")) {
					capabalities.setBrowserName("MicrosoftEdge");
				}
				else {
					System.out.println("no matching browser .....");
					return ;
				}
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
			}
			else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
				// launching browser based on condition - locally
				if(browser.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver(c_option);
					logger.info("Chrome browser opened successfully");
				}
				else if(browser.equalsIgnoreCase("edge")){
					driver = new EdgeDriver(e_option);
					logger.info("Edge browser opened successfully");
				}
				else {
					System.out.println("no matching browser......");
					logger.info("no matching browser......");
					return ;
				}
			}

		logger= LogManager.getLogger(this.getClass());
		logger.info("****************** Driver Launch **********************");
		driver.get(p.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
  	
  	 public  String captureScreen(String name) 
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}
	 @AfterTest(groups = {"sanity","regression","master"})
	 public void tearDown() 
		{
		 logger.info("****************** Execution Stop **********************");
			driver.quit();
			
		}
	 
	 
	
}
