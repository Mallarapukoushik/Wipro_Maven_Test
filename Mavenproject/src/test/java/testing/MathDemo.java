package testing;
 
import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.SkipException;
import org.testng.annotations.Test;
 
//import junit.framework.Assert;
 
public class MathDemo {
 
	@Test (priority=0) //test case
	public void sumTC()
	{
		//logic
		add(20,40);
		//multiplication(10,50);
	}
 
	@Test (priority=1)//test case
	public void multiplicationTC()
	{
		//logic		
		multiplication(20,50);
	}
	
	@Test //(enabled=false)//test case
	public void division()
	{
		//logic	not yet defined
		throw new SkipException("Division logic yet to be implemented");
	}
	
	@Test
	public static void assertDemo()
	{
		Assert.assertEquals("hello", "Hello");
	}
 
	//user defined method for addition
	public static void add(int num1,int num2)
	{
		int sum=num1+num2;
		System.out.println("Sum of "+num1+" & "+num2+" is: "+sum);
	}
 
	//user defined method for multiplication
	public static void multiplication(int num1,int num2)
	{
		int result=num1*num2;
		System.out.println("Multiplication of "+num1+" & "+num2+" is: "+result);
	}
 
}
 