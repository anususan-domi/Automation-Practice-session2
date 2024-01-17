package day29;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Capture Full page screenshot
		/*TakesScreenshot ts=(TakesScreenshot)driver; //TakesScreenshot ts=driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		FileUtils.copyFile(src, trg);
		*/
		
		//Capture screenshot of specific area from the web page   - selenium 4.x
		
		/*WebElement featureproducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src=featureproducts.getScreenshotAs(OutputType.FILE);
		
		File trg=new File(System.getProperty("user.dir")+"\\screenshots\\featuredproducts.png");
		FileUtils.copyFile(src, trg);
			*/
				
		//Capture screenshot of specific element
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src=logo.getScreenshotAs(OutputType.FILE);
		
		File trg=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
		
		
	}

}
