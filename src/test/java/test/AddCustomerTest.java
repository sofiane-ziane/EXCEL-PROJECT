package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCuctomer;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
// global interface
	WebDriver driver;
//get data from excelSheet for testing
	ExcelReader XLR = new ExcelReader("TestData\\login2.xlsx");
	String UserName = XLR.getCellData("LoginInfo", "UserName", 2);                  
	String PassWord = XLR.getCellData("LoginInfo", "PassWord", 2);  
	String FullName = XLR.getCellData("AddCustomer", "FullName", 2);
	String CompanyName = XLR.getCellData("AddCustomer", "CompanyName", 2);
	String Email = XLR.getCellData("AddCustomer", "Email", 2);
	String Phone = XLR.getCellData("AddCustomer", "Phone", 2);
	String Address = XLR.getCellData("AddCustomer", "Address", 2);
	String City = XLR.getCellData("AddCustomer", "Country", 2);
	String Country = XLR.getCellData("AddCustomer", "United States", 2);
	String state = XLR.getCellData("AddCustomer", "state", 2);
	String Zip = XLR.getCellData("AddCustomer", "Zip", 2);
	
	@Test(priority=1)
	public void BrowserFactoryTest() {
		driver = BrowserFactory.inut();
		
	}

	@Test(priority=2)
	public void Login_Page_Test() {

		LoginPage Pagex = PageFactory.initElements(driver, LoginPage.class);
		Pagex.enterUN(UserName);
		Pagex.enterPW(PassWord);
		Pagex.clickLG();
	}

	@Test(priority=3)
	public void DashboardPageTest() {
		DashboardPage pgx = PageFactory.initElements(driver, DashboardPage.class);

		pgx.dashboard("DashBoard", "DashBoard", "title not found");
	}

	@Test(priority=4)
	public void Add_Cuctomer_Test() throws InterruptedException {
		AddCuctomer fil = PageFactory.initElements(driver, AddCuctomer.class);
		fil.custom();
		fil.adding();
		fil.naming(FullName);
		fil.companing(CompanyName);
		fil.emailing(Email);
	    fil.phoneing(Phone);
		fil.addressing(Address);
		fil.citing(City);
		fil.stating(state);
		fil.ziping(Zip);
		fil.countring(Country);
		fil.saving();
		fil.Sumary();
		fil.Listing();
		Thread.sleep(2000);
		fil.VerifyEntredName();
		Thread.sleep(2000);
		fil.deletedNameEntred();
		Thread.sleep(2000);
		fil.deliting();
	}
	//BrowserFactory.teardown();  
}
