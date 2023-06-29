package Common_API_Methods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utility_Method {
public static void EvidanceFileCreator(String filename, String RequestBody, String ResponceBody, int StatusCode) throws IOException {
		
		File NewText = new File ("C:\\Users\\ADMIN\\Desktop\\MSSquare\\RestAPI\\Evidance\\" + filename + ".txt");
		System.out.println("New Blank file Created: "  + NewText.getName());
		
		FileWriter Data = new FileWriter(NewText);
		
		Data.write("Request Body Is :\n" + RequestBody + "\n\n");
	    Data.write("Status Code Is :\n" + StatusCode + "\n\n");
	    Data.write("ResponceBody Is :\n" + ResponceBody + "\n\n");
	    
	    Data.close();
	    System.out.println("Data return into file:" + NewText.getName());
				
}
       public static ArrayList<String> ReadDataExcel(String sheetname, String TestCaseName) throws IOException{
       
       ArrayList<String> ArrayData = new ArrayList<String>();
        //Create the object of file input stream to locate the excel file
       FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\MSSquare\\RestAPI\\Evidance\\TestData.xlsx");
        //Step 2: Open the excel file by creating the object XSSFWorkbook
       XSSFWorkbook WorkBook = new XSSFWorkbook(fis);
        // Step no : Open the desired Sheet
       int CountOfSheet = WorkBook.getNumberOfSheets();
       
       for(int i = 0; i<CountOfSheet; i++)
       {
    	   String SheetName = WorkBook.getSheetName(i);
   		//Access the desire sheet
   			if(SheetName.equalsIgnoreCase(SheetName)){
   				     //Use XSSFSheet to save the sheet into a veriable
   				     XSSFSheet Sheet = WorkBook.getSheetAt(i);
   				     //create iterated thought row and find out in which column the test case name found
   				     Iterator<Row> Rows = Sheet.iterator();
   				     Row FirstRow= Rows.next();
   				     //create the Iterator to Iterated though the cells of 1st Row to find out which cell contains testcase name
   				     Iterator<Cell> CellsOfFirstRow = FirstRow.cellIterator();
   				     int k=0; 
   				     int TC_column=0;
   				     while(CellsOfFirstRow.hasNext())
   				     {
   				    	 Cell CellValue = CellsOfFirstRow.next();
   				    	 if(CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName"))
   				    	 {
   				    		 TC_column= k;
   				    		 System.out.println("Expected colume for test case name:" + k);
   				    	 }
   				    	 k++;  
                 }
   				     //Verify the Row where the desired test case is found test case found and and fetch the entire row
   				     
   				  while(Rows.hasNext())
				     {
				          Row Datarow =Rows.next();	 
				          String TCName=Datarow.getCell(TC_column).getStringCellValue();
				          if(TCName.equalsIgnoreCase(TestCaseName))
				          {
				        	  Iterator<Cell> CellValues =Datarow.cellIterator();
				        	  while(CellValues.hasNext())
				        	  {
				        		  //String Data=CellValues.next().getStringCellValue();
				        		  //ArrayData.add(Data);
				        		  String Data = "";
									Cell CurrentCell = CellValues.next();
									try
									{
										String StringData = CurrentCell.getStringCellValue();
										Data = StringData;
									}
									catch(IllegalStateException e)
									{
									    double doubledata = CurrentCell.getNumericCellValue();
									    Data = Double.toString(doubledata);
									}
									
									ArrayData.add(Data);
								}
								break;
				        		  
				        	 
				          }
				     }     
			     }		
		     }
		return ArrayData;
             }    
       }
