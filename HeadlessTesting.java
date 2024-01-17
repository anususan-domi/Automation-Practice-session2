package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options=new ChromeOptions();
		options.setHeadless(true);
				
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize(); // maximize the page
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);

		String act_title=driver.getTitle();
		String exp_title="OrangeHRM";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("failed");
		}
		
		driver.quit();
		
	}

}
