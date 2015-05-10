package com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testMyksrtc {

WebDriver driver = null;
 ConfigureTest cf1 = new ConfigureTest("firefox");
 WebDriverWait w1 = null;
 String fromPlace = "BANGALORE";
 String toPlace = "THRISSUR";
@BeforeTest
public void  beforeTest1()
{	
	driver =cf1.initializeBrowser();
   w1 = new WebDriverWait(driver, 6000);
	
}
@Test(priority =1)
public void test1()
{	driver.get(cf1.getData("url"));
	driver.manage().window().maximize();
	//WebDriverWait w1 = new WebDriverWait(driver, 6000);
	//w1.until(ExpectedConditions.visibilityOfElementLocated(by.))
	driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
	System.out.println("Page title is :"+ driver.getTitle());
}

@Test(priority = 2)
public void test2()
{ 
w1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Online Ticket Reservation")));
    String masterPage = driver.getWindowHandle();
	driver.findElement(By.linkText("Online Ticket Reservation")).click();
	//List <String> t1 = (List<String>) driver.getWindowHandles();
	for(String i: driver.getWindowHandles())
	  {
		//System.out.println(i);
		if(!i.equals(masterPage))
		   { driver.switchTo().window(i);break;}
	  }
    driver.manage().window().maximize();
	System.out.println(driver.getTitle());
 }

@Test(priority =3)
public void test3()
{
	driver.findElement(By.linkText("Sign-in")).click();
	w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='alreadyMember']/div[2]/div[4]/input")));
	driver.findElement(By.xpath(".//*[@id='alreadyMember']/div[2]/div[4]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='alreadyMember']/div[2]/div[4]/input")).sendKeys("vishnuvenugopal73@gmail.com");
    driver.findElement(By.xpath(".//*[@id='alreadyMember']/div[2]/div[7]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='alreadyMember']/div[2]/div[7]/input")).sendKeys("Aontwcip2014");
   // driver.findElement(By.xpath(".//*[@id='chkTermConditions1']")).submit();
    //System.out.println(Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='chkTermConditions1']")).isSelected(), true));
    driver.findElement(By.xpath(".//*[@id='alreadyMember']/div[2]/button")).click();
  
}
@Test(priority =4)
public void test4()
{
	String user =  driver.findElement(By.xpath(".//*[@id='maindiv']/div[1]/div/div/div/div[2]/ul[2]/li[6]/a")).getText();
	String[]user1 = user.split(" ", 2);
	System.out.println("User logged in: "+user1[1]);
	
}

@Test(priority = 5)
public void oneWaySearch()
  {
	//checking one way option is selected by default
	if(driver.findElement(By.xpath(".//*[@id='optionsRadios2']")).isSelected())
		{
			System.out.println("oneway option is selected by default");	
		}
	else
		{
		driver.findElement(By.xpath(".//*[@id='optionsRadios2']")).submit();
		System.out.println("oneway option is selected by the Tester");	
		}
  //FROM AND tO PLACE SELECTION
	driver.findElement(By.xpath(".//*[@id='matchStartPlace']")).sendKeys(fromPlace);
	WebElement su1 = driver.findElement(By.id("ui-id-3"));
	List <WebElement> su1List = su1.findElements(By.tagName("a"));
	for( WebElement i: su1List)
		{
			if(i.getText().equalsIgnoreCase(fromPlace))
			{i.click();break;}
		}
	//w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-22")));
	//driver.findElement(By.id("ui-id-22")).click();
	driver.findElement(By.xpath(".//*[@id='matchEndPlace']")).sendKeys(toPlace);
	WebElement su2 = driver.findElement(By.id("ui-id-4"));
	List <WebElement> su2List = su2.findElements(By.tagName("a"));
	for( WebElement i: su2List)
		{
			if(i.getText().equalsIgnoreCase(toPlace))
			{i.click();break;}
		}
	//w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-27")));
	//driver.findElement(By.id("ui-id-27")).click();
	
	
  //Date picker
	driver.findElement(By.xpath(".//*[@id='datepicker3']")).click();
	w1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
	WebElement datePicker1 = driver.findElement(By.className("ui-datepicker-calendar"));
	List <WebElement> datePickerRows = datePicker1.findElements(By.tagName("td"));
	for (WebElement i :datePickerRows)
	 {
		//System.out.println(i.getText());
		if(i.getText().equals("8")){i.click(); break;}
	 }
	//selecting no of seats
	WebElement seatPicker1 = driver.findElement(By.name("selectSeats"));
	List <WebElement> seats = seatPicker1.findElements(By.tagName("option"));
	for(WebElement i :seats )
		{
		  if(i.getText().equals("1")){i.click();break ;}
		}
	// clicking on search button
	 driver.findElement(By.xpath(".//*[@id='maindiv']/div[3]/div[1]/div/div/div/div[1]/div[6]/button")).click();
	
  }

@Test(priority=6,enabled=false)

public void readServicedetails1()
	{
	System.out.println(driver.getTitle());
	WebElement mainDiv = driver.findElement(By.id("maindiv"));
	List <WebElement> serviceList = mainDiv.findElements(By.className("frow1products"));
	for(WebElement i : serviceList)
		{
		List <WebElement> busDetails = i.findElements(By.tagName("ul"));
		  for (WebElement j : busDetails)
		  {
			  //System.out.println(j.getText());
				List <WebElement> busDetails1 = j.findElements(By.tagName("li"));
				  for (WebElement k : busDetails1)
				  {
					  List <WebElement> busDetails2 = k.findElements(By.tagName("span"));
				  for (WebElement l : busDetails2)
				  		{ System.out.println(l.getText());
					  
				  		}
					  
				  }
			  
		  }
		}
	
	
	
	}
@Test(priority =6)
public void readDetailsBus()
{   try{ 
	//WebElement mainDiv = driver.findElement(By.xpath(".//*[@id='maindiv']"));
	//w1.until(ExpectedConditions.visibilityOfElementLocated(By.className("frow1products")));
	//List <WebElement> serviceList = mainDiv.findElements(By.tagName("div"));
	//System.out.println("sizee   "+serviceList.size());
	int a = 2;
	int i;
	String noOfService = driver.findElement(By.xpath(".//*[@id='top']/form/div[3]/div/div[3]/div[1]/div[1]/p/span")).getText();
	int noService = Integer.parseInt(noOfService);
	for (a=2;a<=noService;a++)
			{
		 System.out.println(a-1+"==================================================");
		 
		//System.out.println( driver.findElement(By.xpath(".//*[@id='52-O40']")).getAttribute("title"));
		 	for( i=1;i<6;i++)
		 		{
		 		String elementX = ".//*[@id='maindiv']/div["+a+"]/ul/li["+i+"]/span";
		 		System.out.println(driver.findElement(By.xpath(elementX)).getText());
		 	
		 		
		 		}
		 	bookingDetails(a-2);
		
			}}
catch(Exception e) {e.printStackTrace();}
		}
//@Test(priority =8)	
public void bookingDetails(int a)
		{
	//this variable defines which bus to select starting from 0 to noOfservice -1
	 //int a=1;
	 //for (a=0;a<3;a++){
	//String buttonXpath = ".//*[@id='maindiv']/div["+a+"]/ul/li[6]/span";
	 //driver.findElement(By.xpath(buttonXpath)).click();
	//System.out.println(driver.findElement(By.id("selectButton0")).getAttribute("class"));
	String buttonId="selectButton"+a;
	String msgXPath =".//*[@id='dvLoadStatusTR"+a+"']/div/span";
	WebElement selectButton = driver.findElement(By.id(buttonId));
	scrollTo(driver, selectButton);
	selectButton.click();
	 //w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dvLoadStatusTR']")));
	try{
		WebElement msg = driver.findElement(By.xpath(msgXPath));
		String msgAlert = msg.getText();
			if (msgAlert.equalsIgnoreCase("No seats are available For the selected Bus Service on the given date.Please select another."))
				{
					System.out.println("Seats not available");
				}
		}
	catch(Exception e) {  System.out.println("Seats are Available" );
	WebElement closeButtonE = driver.findElement(By.xpath(".//*[@id='dvLoadStatusTR']/ul/li[2]/div[3]/button[2]"));
	scrollTo(driver, closeButtonE);
	closeButtonE.click();
	}
	 }
	
	

@AfterTest
public void afterTest()
{
	driver.quit();
}

public static void scrollTo(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
}
	
	

}
