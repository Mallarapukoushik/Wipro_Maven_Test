package jpetStorePages;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
 
public class JpetLoginPage {

	WebDriver driver;

	public JpetLoginPage(WebDriver driver) {

		this.driver=driver;

	}

	By signIn=By.linkText("Sign In");

	By userName=By.id("username");

	By password=By.id("password");

	By LoginBtn=By.xpath("//button[text()='Login']");


	public void loginIntoJpet(String name,String pass) {

		driver.findElement(signIn).click();

		driver.findElement(userName).clear();

		driver.findElement(userName).sendKeys(name);

		driver.findElement(password).clear();

		driver.findElement(password).sendKeys(pass);


        WebElement submitButton = driver.findElement(LoginBtn);

		Actions actions = new Actions(driver);

		actions.moveToElement(submitButton).click().perform();

	}
 
}