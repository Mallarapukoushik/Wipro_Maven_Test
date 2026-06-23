package testing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Baseclass;

public class Parameter extends Baseclass {
	@Parameters({"browser"})
	@Test
	public void orangeDemo(String browser)
	{	
		invokeBrowser(browser);
		driver.get("https://www.google.com");
	}

}
