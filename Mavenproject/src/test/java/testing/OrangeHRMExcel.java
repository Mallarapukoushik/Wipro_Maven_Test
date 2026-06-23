package testing;
 
import java.io.FileInputStream;
import java.time.Duration;
 
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import util.Baseclass;
 
public class OrangeHRMExcel extends Baseclass {
 
    @BeforeMethod
    public void setup() {
        invokeBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @Test
    public void loginTestFromExcel() throws Exception {
 
        FileInputStream file = new FileInputStream("./Downloads/wiproData.xlsx");
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheetAt(0);
 
        int rowCount = sheet.getPhysicalNumberOfRows();
 
        for (int i = 1; i < rowCount; i++) {
 
            Row row = sheet.getRow(i);
 
            String name = row.getCell(0).toString();
            String pass = row.getCell(1).toString();
 
            WebElement username = driver.findElement(By.name("username"));
            username.clear();
            username.sendKeys(name);
 
            WebElement password = driver.findElement(By.name("password"));
            password.clear();
            password.sendKeys(pass);
 
            driver.findElement(By.xpath("//button[@type='submit']")).click();
 
            Thread.sleep(2000);
 
            boolean isDashboardDisplayed =
                    driver.findElements(By.xpath("//h6[text()='Dashboard']")).size() > 0;
 
            boolean isErrorDisplayed =
                    driver.findElements(By.xpath("//p[contains(@class,'alert-content-text')]")).size() > 0;
 
            if (name.equals("Admin") && pass.equals("admin123")) {
 
                if (!isDashboardDisplayed) {
                    throw new RuntimeException("Valid login failed for row " + i);
                }
 
                driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
                driver.findElement(By.xpath("//a[text()='Logout']")).click();
 
                Thread.sleep(2000);
 
            } else {
 
                if (!isErrorDisplayed) {
                    throw new RuntimeException("Invalid Login did not show error for row " + i);
                }
            }
        }
 
        wb.close();
        file.close();
    }
}