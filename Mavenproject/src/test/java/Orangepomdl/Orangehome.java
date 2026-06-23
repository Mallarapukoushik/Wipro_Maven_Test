package Orangepomdl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Orangehome {
	WebDriver driver;
	public Orangehome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboard;
    @FindBy(xpath = "//img[@alt='profile picture']")
    WebElement profileMenu;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutBtn;
    

     public boolean isDashboardDisplayed() {
     return dashboard.isDisplayed();
    }

     
    public void clickProfile() {
           profileMenu.click();
       }

       public void clickLogout() {
           logoutBtn.click();
       }
}
