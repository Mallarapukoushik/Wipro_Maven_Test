package Jpet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Jpetlogin {
		 
	    WebDriver driver;
	 
	    public Jpetlogin(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    By signIn = By.xpath("//a[@href='/account/signonForm']");
        By username = By.name("username");  
        By password = By.name("password");
	    By loginBtn = By.xpath("//button[@type='submit']");
	 
	    public void clickSignIn() {
	        driver.findElement(signIn).click();
	    }

        public void username(String uname) {   
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(uname);
    }

    public void password(String pwd) {   
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
    }

	 
	    public void clickLogin() {
	        Actions actions = new Actions(driver);
	 
	        actions.moveToElement(driver.findElement(loginBtn)).perform();
	        driver.findElement(loginBtn).click();
	    }
	}
