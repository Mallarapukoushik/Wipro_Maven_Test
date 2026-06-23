package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Step 1: Open page
        driver.get("https://demoqa.com/frames");

        // Step 2: Switch to iframe
        driver.switchTo().frame("frame1");

        // Step 3: Get text
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);

        // Step 4: Switch back
        driver.switchTo().defaultContent();

        //driver.quit();
    }
}
