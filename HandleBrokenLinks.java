package day29;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/*
 * 1) link   href="xyz.com"
2) status code >=400
 */
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links:"+links.size());
		
		int brokenlinks=0;
		
		for(WebElement linkEle:links)
		{
			String hrefAttValue=linkEle.getAttribute("href");
			
			if(hrefAttValue==null || hrefAttValue.isEmpty())
			{
				System.out.println("href attribute value is empty");
				continue;
			}
			
			URL linkurl=new URL(hrefAttValue); //  Convert String ---> URL format
			
			
			HttpURLConnection conn=(HttpURLConnection)linkurl.openConnection();
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefAttValue+"=====> Broken link");
				brokenlinks++;
			}
			else
			{
				System.out.println(hrefAttValue+"=====> Not Broken link");
			}
			
		}

		
		System.out.println("Total number of broken links:"+brokenlinks );
		
	}

}







