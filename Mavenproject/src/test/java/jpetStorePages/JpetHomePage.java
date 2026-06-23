package jpetStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class JpetHomePage {

    WebDriver driver;

    public JpetHomePage(WebDriver driver) {
        this.driver = driver;
    }
    By birdsCategory = By.linkText("Birds");
    By amazonParrot = By.linkText("Amazon Parrot");
    By addToCart = By.xpath("//button[text()='Add to Cart']");
    By checkout = By.xpath("//a[text()='Proceed to Checkout']");
    public void checkOutItem() {
    	 Actions actions = new Actions(driver);
         actions.moveToElement(driver.findElement(birdsCategory)).perform();
        driver.findElement(birdsCategory).click();
        driver.findElement(amazonParrot).click();
        driver.findElement(addToCart).click();
        driver.findElement(checkout).click();

        System.out.println("Amazon Parrot added to cart and checkout started");
    }
}