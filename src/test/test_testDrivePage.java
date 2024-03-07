package test;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.lexus_testDrivePage;

public class test_testDrivePage {
	
	private static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		
		testDrive();
	}
	
	private static String getTodayDate() 
	{
		LocalDate currentDate = LocalDate.now();
        int t_day = currentDate.getDayOfMonth();
        String stringTdate = String.valueOf(t_day);
        return stringTdate;

	}
	
	public static void testDrive() {
		
		// include drivers
				System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chrome driver\\chromedriver-win64\\chromedriver.exe");
				
				
				//set window maximum size 
				driver.manage().window().maximize();
				
				try {
					
					//get the web application
		       	 	driver.get("https://www.lexus.com.sg/en/contact-us/book-a-test-drive.html?model=ux%20300e");
		       	 	
		       	 	//click on cookies popup window
		       	    lexus_testDrivePage.cookiebutton_search(driver).click();
		       	 	
		       	 	//find the first name field and pass data into it		       	 
		       	    lexus_testDrivePage.firstname_search(driver).sendKeys("CPL");
		            
		            //find the last name field and pass data into it
		       	    lexus_testDrivePage.lastname_search(driver).sendKeys("Test");
		            
		            //find the email field and pass data into it
		       	 
		       	    lexus_testDrivePage.email_search(driver).sendKeys("qa@convertium.com");

		       	    
		            //active the dial code drop down and set dial code to Singapore +65	       	    
		       	    List<WebElement> dialCodeSearchList = lexus_testDrivePage.dial_code_list_search(driver);		    
		       	    GetDialCodeSearchDropDown(dialCodeSearchList);		       	    

		            //find the phone number field and set the value 		            
		       	    lexus_testDrivePage.phone_number_search(driver).sendKeys("91234567");
		            
		       	 	
		       	 	//select a today date from calendar 
		       	 	/*
		       	 	 * Though the question paper gave to select Preferred Date: 10 Jan 2021 It cannot be achieved 
		       	 	 * because normally appointment can be made after today date. The user interface has built to select
		       	 	 * only dates after current date. Therefore has to make a assumption that user may select any date today or future dates
		       	 	 *  
		       	 	 */
		       	 	
		       	    List<WebElement> date_list = lexus_testDrivePage.day_container_search(driver);
		       	    GetDatesetDatepicker(date_list);
		       	    
			       	 //click  on preferred time input field to enable	 			       	 
			       	List<WebElement> time_list = lexus_testDrivePage.list_search(driver);
			       	GetTimeSearchDropDown(time_list);
			       	
			       	//click number of pax dropdown			       	
			       	List<WebElement> pax_list = lexus_testDrivePage.list_search(driver);
			       	GetNumPaxDropDown(pax_list);
			 
			       	
			       	//check preferred model UX 300e selected			       
		            WebElement dropdownPreModel = lexus_testDrivePage.preferred_model_search(driver);
		            boolean isModelSelected = GetPreModelSelectValue(dropdownPreModel);
		            		            
			       	//click to enable test drive option		            
		            List<WebElement> drive_list = lexus_testDrivePage.list_search(driver);
		            GetTestDriverDropDown(drive_list);
		            
			       	//check checkbox_driving_license
			       	lexus_testDrivePage.driving_lc_chkbox_search(driver).click();
		       	 	
		       	 	//check checkbox_terms_conditions
			       	lexus_testDrivePage.terms_chkbox_search(driver).click();
		       	 	
		       	 	//check checkbox_privacy_policy
			       	lexus_testDrivePage.privacy_chkbox_search(driver).click();
		       	 	
		       	 	//check checkbox_marketing
			       	lexus_testDrivePage.marketing_chkbox_search(driver).click();
		       	    
		       	    // Ensure Submit button is enabled
			       	boolean isSubmitEnabled = lexus_testDrivePage.submit_btn_search(driver).isEnabled();


		            // Verification of Preferred model selected and submit button enabled
		            System.out.println("Model UX 300e pre-selected: " + isModelSelected);
		            System.out.println("Submit button enabled: " + isSubmitEnabled);
		            
		            
		            //The form need not to submit as per the instruction given in the question		         
		            //lexus_testDrivePage.submit_btn_search(driver).click();
		            

				}catch(UnhandledAlertException e) {
					
					System.out.println("something occured");
		        	driver.quit();
				}

		
	}
	

	public static void GetDialCodeSearchDropDown(List<WebElement> list) { 
		
		lexus_testDrivePage.dial_code_search(driver).click();
		
         for(WebElement option : list){
             String text = option.getText();

                 if(text.equals("Singapore+65")){
                     option.click();
                     break;
                 }
         }
	}
	
	public static void GetDatesetDatepicker(List <WebElement> list_days) {
		
   	    lexus_testDrivePage.datepicker_search(driver).click();		
		String today_date = getTodayDate();		            
       	 for(WebElement opt_dates : list_days){
             String d_text = opt_dates.getText();

                 if(d_text.equals(today_date)){ //select current date from options in calendar
                	 opt_dates.click();
                     break;
                 }
         } 
	}
	
	public static boolean GetPreModelSelectValue(WebElement dropdownPreModel) {
		
		 Select dropdownSelected = new Select(dropdownPreModel);

         boolean  isModelSelected = false;
         WebElement selectedPreModelOption = dropdownSelected.getFirstSelectedOption();
         if (selectedPreModelOption != null) {
         	String preModelNeed = "UX 300e";
             String selectedValue = selectedPreModelOption.getAttribute("value");
             if(selectedValue.equals(preModelNeed)) {
             	
             	 isModelSelected = true;
             }               
         } 
         return isModelSelected;
	}
	
    public static void GetTimeSearchDropDown(List<WebElement> time_list) { 
		
    	 lexus_testDrivePage.time_search(driver).click();
	       	for(WebElement opt_times : time_list){
	             String t_text = opt_times.getText();
	
	                 if(t_text.equals("18:00")){ 
	                	 opt_times.click();
	                     break;
	                 }
	         }
	       	
	       	
	}
    
    public static void GetNumPaxDropDown(List<WebElement> pax_list) { 
		
    	lexus_testDrivePage.num_of_pax_search(driver).click();       	
       	for(WebElement opt_paxes : pax_list){
             String p_text = opt_paxes.getText();

                 if(p_text.equals("1")){ 
                	 opt_paxes.click();
                     break;
                 }
         }
	       	
	       	
	}
    
   public static void GetTestDriverDropDown(List<WebElement> drive_list) { 
		
	 	lexus_testDrivePage.t_drive_opt_search(driver).click();      	

       	for(WebElement opt_drives : drive_list){
             String d_text = opt_drives.getText();

                 if(d_text.equals("Lexus Test Drive Concierge")){
                	 opt_drives.click();
                     break;
                 }
         }
	       	
	}
   
	
	
	

	
}
