package Selenium;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter number:");
		int choice = s.nextInt();
		WebDriver driver = new EdgeDriver();
		if(choice==1) {
			driver.get("https://www.google.com");
		}
		else if(choice==2) {
			driver.get("https://www.microsoft.com");
		}
		else {
			System.out.println("invalid");
		}
		s.close();
	}
}