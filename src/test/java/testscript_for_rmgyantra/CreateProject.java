package testscript_for_rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class CreateProject {

	public static void main(String[] args) throws InterruptedException, SQLException {
		String projectname = "OFOS_1.1.09";
	WebDriver driver=new ChromeDriver();
	driver.get("http://rmgtestingserver:8084/welcome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname);
	JavascriptExecutor j=(JavascriptExecutor) driver;
	j.executeScript("document.getElementsByName(\"teamSize\").values=\"3\"");
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sudip");
	WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s=new Select(ele);
	s.selectByVisibleText("Created");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	Thread.sleep(5000);
	boolean flag = false;
	Connection con=null;
	try {
	Driver driver2=new Driver();
	DriverManager.registerDriver(driver2);
	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	String query = "select * from project;";
	ResultSet result = state.executeQuery(query);
	boolean Flage = false;
	while (result.next()) {
		String actual_Project = result.getString(4);
		System.out.println(actual_Project);
		if (actual_Project.equalsIgnoreCase(projectname)) {
			Flage=true;
			break;
		}
		
		if (Flage) {
			System.out.println("Project Is Created");
		}
		else {
			System.out.println("Project Is not Created");
		}
		
	}
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		con.close();
		System.err.println("DataBase is Close");
	}
	
	}

}
