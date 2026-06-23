package Orangepomdl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orangelogin {
	WebDriver driver;
	public Orangelogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }

}
