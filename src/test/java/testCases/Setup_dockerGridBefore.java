package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup_dockerGridBefore {
	
	@BeforeTest
	public void startDockerGrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c  start  start_dockergrid.bat");
		Thread.sleep(20000);
		
		
	}	
	

}
