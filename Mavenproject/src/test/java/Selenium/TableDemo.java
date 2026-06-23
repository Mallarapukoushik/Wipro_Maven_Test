package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import util.Baseclass;
 
public class TableDemo extends Baseclass{
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		invokeBrowser("edge");
		driver.get("https://demo.guru99.com/test/web-table-element.php");
 
		//Total no of columns and rows
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		int size = columns.size();
		System.out.println("No of columns: "+size);
 
		//find the total no rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int totalrows = rows.size();
		System.out.println("Total no of rows: "+totalrows);
 
 
		//do nested loop using x & y to loop through all the records in a table
		for(int i=0;i<columns.size();i++){
 
			System.out.println(columns.get(i).getText());
		}
			for(int i=0;i<rows.size();i++){
			System.out.println(rows.get(i).getText());
			
		}
       String value = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[4]/td[4]")).getText();
		System.out.println(value);
		//closeBrowser();
 
 
		//to find the particular cell value
 
	}
 
}
 