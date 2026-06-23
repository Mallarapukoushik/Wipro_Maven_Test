package Selenium;
 
import java.io.File;
import java.io.IOException;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
import com.google.common.io.Files;
 
public class Screenshot {
 
    public static void main(String[] args) throws IOException, InterruptedException {
 
   
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
 
  
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
        // Save screenshot in screenshot folder
        Files.copy(src,new File("./screenshot/"+ "screenshot-"+ System.currentTimeMillis()+ ".png"));
 
        System.out.println("Screenshot captured");
 
        // Close browser
        Thread.sleep(2000);
        driver.quit();
    }
}
