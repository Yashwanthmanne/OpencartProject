package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


 

public class DataProviders {
    @DataProvider(name="Logindata")
	public String [][] getdata() throws IOException 
	{
	 String path =".\\testData\\Opencart_LoginData11.xlsx";  // taking xl file from test data 
	 ExcelUtility1 xlutil = new ExcelUtility1(path);
	
	int total_rows = xlutil.getRowCount("Sheet1");
	int total_cols = xlutil.getCellCount("Sheet1",1);
	
	String logindata[][]= new  String[total_rows][total_cols];// creating two dimensional Array
	
	for  (int i=1; i<=total_rows;i++)// reading data from excel and storing in data providers
	{
		
		for(int j=0; j<total_cols;j++)
		{
			logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
		}
		
	}
		return logindata;// returning two dimensional array
		
	}
	
	

}
