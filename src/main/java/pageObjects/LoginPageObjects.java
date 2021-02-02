package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageObjects {
	public LoginPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.nobroker.app:id/et_signup_phone")
	public WebElement phonenumbertextbox;
	
	@AndroidFindBy(id="com.nobroker.app:id/btn_signup")
	public WebElement signupbutton;
	
	
	@AndroidFindBy(id="com.nobroker.app:id/rb_signup_pwd")
	public WebElement havepasswordradiobutton;
//	
	@AndroidFindBy(id="com.nobroker.app:id/et_signup_pwd")
	public WebElement passwordtextbox;
	
	@AndroidFindBy(className ="android.widget.CheckBox")
	public List <WebElement> reportcheckboxes;
	
	@AndroidFindBy(id="com.nobroker.app:id/btn_report")
	public WebElement reportbutton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3 BHK']")
	public WebElement correctdropdown;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='4+ BHK']")
	public WebElement fourplusbhk;

	@AndroidFindBy(id="com.nobroker.app:id/btn_save")
	public WebElement savebutton;
	
	@AndroidFindBy(id="com.nobroker.app:id/edt_others")
	public WebElement addnotetextarea;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Thank you for the feedback']")
	public WebElement successmsg;
	
	
}
