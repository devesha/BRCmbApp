package com.mb.brc.modules;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.mb.brc.common.UtilFunctions;


public class PostPropertyRequirement{
	
	private String addIconID="fab_plus";
	private String addPropertyIcon="add_property_icon";
	private String addRequirmentIcon="add_req_icon";
	private String addUpdateIcon="add_an_up_date_icon";
	
	//Post Property
	private String BuyPropertyType_ID="buy";
	private String RentPropertyType_ID="rent";
	private String PgPropertyType_ID="pg";
	private String ResidentialPropertyType_ID="residential";
	private String CommercialPropertyType_ID="commercial";
	private String flat_ID="flat";
	private String builderFloor_ID="builderfloor";
	private String penthouse_ID="penthouse";
	private String house_ID="house";
	private String villa_ID="villa";
	private String studioapartment_ID="studioapartment";
	private String plot_ID="plot";
	private String openCitySelection_ID="city";
	private String openLocalitySelection_ID="locality";
	private String openProjectSelection_ID="project";
	private String selectBedroom_ID="rb_2";
	private String selectBedroomReq_ID="cb_2";
	private String selectKitchenYes_ID="yes";
	private String selectBathroomYes_ID="yes";
	private String area_ID="area";
	private String price_ID="price";
	private String pool_ID="pool";
	private String garden_ID="garden";
	private String road_ID="road";
	private String floorNo_ID="floors";
	private String totalFloor_ID="totalfloors";
	private String readyToMove_ID="ready_to_move";
	private String underConstruction_ID="";
	private String ageOfConstruction_ID="ageofconst";
	private String fullyFurnished_ID="fully_furnished";
	private String notes_ID="add_notes";
	private String post_ID="post";
	private String selectCity_ID="line";
	private String selectLocality_CLASS="android.widget.RelativeLayout";
	private String selectProject_Class="android.widget.RelativeLayout";
	private String floorNumber_Ground_Name="Ground";
	private String totalFloorNumber_5_Name="5";
	private String NewConstruction_Name="New Construction";
	
	private String reqlocalitySelection_ID="register_edit_location";
	private String enterLocalityProjectDetailID="autocompletetext";
	//private String selectLocality_xpath="//EditText[contains(@text,'magic city, Long Island, Andaman & Nicobar')]";
	private String donebtnLocalitySelection_ID="tv_location_cancel";
	private String selectLocalityRequirement_Id="name";
	private String selectFloor_Name="Any Floor";
	private String dealTypeDirect_ID="direct";
	private String dealTypeThrough_ID=	"through";	
	private String title_ID="title";
	
	//Update parameters
	 private String description_id="desc";
	 private String gallery_id="gallery";
	 private String camera_id="camera";
	 private String attachment_id="attachment";
	 private String location_id="location";
	 private String enterlocalityUpdate_ID="localities";
	 private String selectLocalityUpdate_ID="name";
	 
	
	private  AndroidDriver driver;
	UtilFunctions util = new UtilFunctions();
	
	
	public PostPropertyRequirement(AndroidDriver driver) {
		super();
		this.driver = driver;
	    }
	
	Board br = new Board(driver);
	public void swipe() throws InterruptedException {
	        Dimension size;
	        size = driver.manage().window().getSize();
	        int starty = (int) (size.height * 0.70);
	        int endy = (int) (size.height * 0.30);
	        int startx = size.width / 2;
	        Thread.sleep(1000);
	        driver.swipe(startx, starty, startx, endy, 3000);
	        Thread.sleep(1000);
	 }
	
	public void postProperty() throws InterruptedException
	{
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 br.HomeFunc(driver);
	 driver.findElement(By.id(addIconID)).click();
	 driver.findElement(By.id(addPropertyIcon)).click();
	 driver.findElement(By.id(flat_ID)).click();
	 this.swipe();
	 driver.findElement(By.id(openCitySelection_ID)).sendKeys("anda");
	 driver.findElement(By.id(selectCity_ID)).click();
	 driver.hideKeyboard();
	 
	// driver.scrollTo("Project");
	//this.swipe();
	 // driver.scrollToExact("Bedroom*");
	 //driver.findElement(By.id(openLocalitySelection_ID)).click();
	 driver.findElement(By.id(openProjectSelection_ID)).sendKeys("QC");
	 Thread.sleep(2000);
	 driver.findElement(By.id("line4")).click();
	 //driver.findElement(By.name("QC test project"));
	 driver.findElement(By.className(selectProject_Class)).click();
	 Thread.sleep(2000);
	 driver.hideKeyboard();
	 
	 driver.findElement(By.id(selectBedroom_ID)).click();
	 
	 driver.findElement(By.id(area_ID)).sendKeys("2000");
	 driver.hideKeyboard();
	 driver.findElement(By.id(price_ID)).sendKeys("25252525");
	 driver.hideKeyboard();
	 this.swipe();
	 driver.findElement(By.id(pool_ID)).click();
	 driver.findElement(By.id(floorNo_ID)).click();
	 driver.findElement(By.name(floorNumber_Ground_Name)).click();
	 driver.findElement(By.id(totalFloor_ID)).click();
	 driver.findElement(By.name(totalFloorNumber_5_Name)).click();
	 driver.findElement(By.id(readyToMove_ID)).click();
	 driver.findElement(By.id(ageOfConstruction_ID)).click();
	 driver.findElement(By.name(NewConstruction_Name)).click();
	 this.swipe();
	 driver.findElement(By.id(fullyFurnished_ID)).click();
	 this.swipe();
	 driver.findElement(By.id(notes_ID)).sendKeys("Test Property BROKERCONNECT");
	 driver.hideKeyboard();
	 driver.findElement(By.id(post_ID)).click();
	 Thread.sleep(3000);
	 Assert.assertEquals("Board",driver.findElement(By.id(title_ID)).getText(),"postProperty not success");
		
	}
	
	
	public void postRequirement() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 br.HomeFunc(driver);
		driver.findElement(By.id(addIconID)).click();
		driver.findElement(By.id(addRequirmentIcon)).click();
		driver.findElement(By.id(RentPropertyType_ID)).click();
		driver.findElement(By.id(BuyPropertyType_ID)).click();
		driver.findElement(By.id(flat_ID)).click();	 
		this.swipe();
		 driver.findElement(By.id(openCitySelection_ID)).sendKeys("anda");
		 driver.findElement(By.id(selectCity_ID)).click();
		 driver.hideKeyboard();
		
		 driver.findElement(By.id(reqlocalitySelection_ID)).click();
		 driver.findElement(By.id(enterLocalityProjectDetailID)).sendKeys("magic city");
		 driver.findElement(By.id(selectLocalityRequirement_Id)).click();
		 driver.findElement(By.id(donebtnLocalitySelection_ID)).click();
		 driver.findElement(By.id(selectBedroomReq_ID)).click();
		 this.swipe();
		 
		 driver.findElement(By.id(fullyFurnished_ID)).click();
		 driver.findElement(By.id(readyToMove_ID)).click();
		 
		 this.swipe();
		 driver.findElement(By.id(dealTypeDirect_ID)).click();
		
		 driver.findElement(By.id(notes_ID)).sendKeys("Requirement From BrokerConnect" );
		 driver.hideKeyboard();
		 this.swipe();
		 
		 driver.findElement(By.id(post_ID)).click();
		 Thread.sleep(3000);
		 Assert.assertEquals("Board",driver.findElement(By.id(title_ID)).getText(),"post Requirment not success");

		
	}
	 private String tapOkUpdate_ID="ok";
	public void postUpdate() throws InterruptedException
	{
		boolean ispresent;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 br.HomeFunc(driver);
		driver.findElement(By.id(addIconID)).click();
		driver.findElement(By.id(addUpdateIcon)).click();
		
		try {
			driver.findElement(By.id(tapOkUpdate_ID)).click();
		  
		 } catch (NoSuchElementException e) {
		    System.out.println("coach no appeared");
		 }
		
		driver.findElement(By.id(description_id)).sendKeys("This is a update in BROKER CONNECT APP");
		
		driver.findElement(By.id(location_id)).click();
		driver.findElement(By.id(enterlocalityUpdate_ID)).sendKeys("magic city");
		Thread.sleep(3000);
		driver.findElement(By.id(selectLocalityUpdate_ID)).click();
		driver.hideKeyboard();
		driver.findElement(By.id(post_ID)).click();
		 Thread.sleep(3000);
		 Assert.assertEquals("Board",driver.findElement(By.id(title_ID)).getText(),"post update not success");
	}
	
	
	
}
