package Practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getData()
	{
		//2 set of data, "Hello World","!@$%#&^"
		Object[][] data=new Object[][]
				{
			{"Hello World"},{"!@$%#&^"} 
				};
		return data;
	}

}
