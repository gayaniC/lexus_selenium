package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class lexus_testDrivePage {
	
	private static WebElement element = null;
    private static List<WebElement> elementList;

	
	public static WebElement cookiebutton_search(WebDriver driver) {
		
		element = driver.findElement(By.id("consent_prompt_submit"));
		return element;
	}
	
	public static WebElement firstname_search(WebDriver driver) {
		
		element = driver.findElement(By.id("input_first_name"));
		return element;
	}
	
	public static WebElement lastname_search(WebDriver driver) {
		
		element = driver.findElement(By.id("input_last_name"));
		return element;
	}
	
	public static WebElement email_search(WebDriver driver) {
		
		element = driver.findElement(By.id("input_email_address"));
		return element;
	}
	
	public static WebElement dial_code_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[@class='iti__selected-dial-code']"));
		return element;
	}
	
	public static  List<WebElement> dial_code_list_search(WebDriver driver) {
		
		elementList = driver.findElements(By.xpath("//div[@class='iti__flag-container']/ul/li"));
		return elementList;
	}
	
	public static WebElement phone_number_search(WebDriver driver) {
		
		element = driver.findElement(By.id("input_phone_number"));
		return element;
	}
	
	public static WebElement datepicker_search(WebDriver driver) {
		
		element = driver.findElement(By.id("datepicker_preferred_date"));
		return element;
	}
	
	public static List<WebElement> day_container_search(WebDriver driver) {
		
		elementList = driver.findElements(By.xpath("//div[@class='dayContainer']/span"));
		return elementList;
	}
	
	public static WebElement time_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[@data-value='Preferred time']"));
		return element;
	}
	
	public static List<WebElement> list_search(WebDriver driver) {
		
		elementList = driver.findElements(By.xpath("//div[@class='choices__list']/div"));
		return elementList;
	}
	
	public static WebElement num_of_pax_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[@data-value='Number of pax']"));
		return element;
	}

	
	public static WebElement preferred_model_search(WebDriver driver) {
		
		element = driver.findElement(By.id("select_preferred_models"));
		return element;
	}
	
	public static WebElement t_drive_opt_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[@data-value='Select a test drive option']"));
		return element;
	}
	
	
	public static WebElement driving_lc_chkbox_search(WebDriver driver) {
		
		element =  driver.findElement(By.id("checkbox_driving_license"));
		return element;
	}
		
	public static WebElement terms_chkbox_search(WebDriver driver) {
		
		element = driver.findElement(By.id("checkbox_terms_conditions"));
		return element;
	}
	
	public static WebElement privacy_chkbox_search(WebDriver driver) {
	
		element = driver.findElement(By.id("checkbox_privacy_policy"));
		return element;
	}
	
	public static WebElement marketing_chkbox_search(WebDriver driver) {
	
		element = driver.findElement(By.id("checkbox_marketing"));
		return element;
	}
	
	public static WebElement submit_btn_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}
	
}
