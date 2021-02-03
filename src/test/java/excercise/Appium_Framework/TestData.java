package excercise.Appium_Framework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		Object[][] obj=new Object[][]
				{
			
			{"Bangalore","Marathahalli","HSR Layout","1237567899","nobroker123","Testing","Thank you for the feedback"}
				};
				
				return obj;
				
	}

}
