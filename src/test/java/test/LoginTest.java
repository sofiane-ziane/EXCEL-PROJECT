package test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	// 1.Global variables
	WebDriver driver;
	ExcelReader XLR = new ExcelReader("TestData\\login2.xlsx");
	String UserName = XLR.getCellData("LoginInfo", "UserName", 2);                  
	String PassWord = XLR.getCellData("LoginInfo", "PassWord", 2);              
	@Test
	public void loginTest1() {
		driver = BrowserFactory.inut(); // BrowserFactory.unit() from util package
		// class.method // BrowserFactory.unit() = drive (from same class)
		// driver in loginTest operated as well by global variable (WebDriver driver)
		// driver is connection point between BrowserFactory.unit() and global variable
		// (WebDriver driver)
	
		// create object : LoginPage log = new LoginPage();
		LoginPage Pagex = PageFactory.initElements(driver, LoginPage.class); // PageFactory transfer WebDriver deiver to
																				// LoginPage
		Pagex.enterUN(UserName);
		Pagex.enterPW(PassWord);
		Pagex.clickLG();
	}

	@Test
	public void loginTest3() {
// create object
		DashboardPage pgx = PageFactory.initElements(driver, DashboardPage.class);
// 	pgx.dashboard();
		pgx.dashboard("DashBoard", "DashBoard", "title not found");
	}

//	@Test
//	public void loginTest4() {
//		AddCuctomer fil = PageFactory.initElements(driver, AddCuctomer.class);
//
//		// fil.custom();
//		fil.adding();
//		fil.naming("jojifer");
//		fil.companing("BITS");
//		fil.emailing("abc123@gmail.com");
//		// fil.phoneing("8575434");
//		fil.addressing("rtx140");
//		fil.citing("goodland");
//		fil.stating("gogg");
//		// fil.ziping(45034);
//		fil.countring("United States");
//
//	}
}
