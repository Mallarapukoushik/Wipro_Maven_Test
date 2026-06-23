package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import util.Baseclass;
 
public class Practice extends Baseclass{
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		invokeBrowser("edge");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Total no of columns and rows
				List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[1]/td"));
				int colsize = columns.size();
				System.out.println("No of columns: "+colsize);
		 
				//find the total no rows
				List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr"));
				int totalrows = rows.size();
				System.out.println("Total no of rows: "+totalrows);
				
				for(int i=0;i<columns.size();i++){
					 
					System.out.println(columns.get(i).getText());
				}
					for(int i=0;i<rows.size();i++){
					System.out.println(rows.get(i).getText());
					
				}
		       String value = driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[4]")).getText();
				System.out.println(value);
	}
}
 
		