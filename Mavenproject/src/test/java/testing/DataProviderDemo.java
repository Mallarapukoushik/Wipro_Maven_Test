package testing;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
 
public class DataProviderDemo {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("Number: "+n+" value: "+s);
  }
 
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
    };
  }
}
