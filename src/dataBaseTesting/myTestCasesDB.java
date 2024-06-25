package dataBaseTesting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class myTestCasesDB {
	
	Connection con ;
	 Statement stmt ;
	 ResultSet rs ;
	String URL = "https://magento.softwaretestingboard.com/customer/account/create/";
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void mySetup () throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","ethar123");
		
	}
//	@Test (priority = 1)
//	public void  addData () throws SQLException {
//		String Query = " Insert Into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)"+ "values(77,'ethar','fowzi','ababneh','0798','12-23-34','amman',00,'jordan','rr',88,00,90)";
//		
//		stmt = con.createStatement();
//		int adrow = stmt.executeUpdate(Query);
//		
//		Assert.assertEquals(adrow>0, true);
//	
//	}
	@Test (priority =3)
	public void updateData () throws SQLException {
		stmt = con.createStatement();
		
		String Query = "update customers set customerName = 'ethar' where customerNumber = 103";
	
	
	int adrow = stmt.executeUpdate(Query);
	
	Assert.assertEquals(adrow>0, true);
}
	
	@Test (priority = 2)
	public void getData() throws SQLException {
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from customers where customerNumber=103");
		
		int customerNum  ;
		String customerName = null  ;
	
		while (rs.next()) {
			  customerNum = rs.getInt("customerNumber");
			   customerName = rs.getString("customerName");
			
			 
		}
		driver.get(URL);
		driver.findElement(By.id("firstname")).sendKeys(customerName);	
		
	}


	

//	@Test(priority=4)
//	public void deleteData () throws SQLException {
//		
//		String Query = "delete from customers where customerNumber=103";
//		stmt = con.createStatement();
//		int adrow = stmt.executeUpdate(Query);
//				Assert.assertEquals(adrow>0, true);
//		
//	}
}

