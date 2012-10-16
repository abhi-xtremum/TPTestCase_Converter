package targetprocess.testcase.converter;

import java.io.*;
import au.com.bytecode.opencsv.*;
import java.util.*;

public class Converter {

	
	int project_id;
	String entity_type;
	String testcase_id;
	String testcase_name;
	String last_run_date;
	String creation_date;
	String project;
	String user_story;
	String lastfailure_comment;
	String last_status;
	String steps;
	String success;
	String priority;
	String tags;
	String owner;
	
	
	public static void main(String[] args) throws IOException {

		//Creating object of the class so as to instantiate the string variables as empty strings.
		Converter obj = new Converter();

	    System.out.println("Enter ProjectID:\n");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
			obj.project_id = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		
		System.out.println("This converter will currently accept your test-cases in this format:");
		System.out.println("1.Description 2.Steps 3.Expected Result \n These parameters should be the 2nd, 3rd, 4th column in your testcase");
		
		try {
			
			//Creating object for CSVReader accepting the filename. Currently hard-coded.
			CSVReader testcase_reader = new CSVReader(new FileReader("/home/abhijeet/Desktop/MU/MUTestcases_TargetProcess/sample_praxifytc.csv"));
			String[] nextLine;
			int j=0;
			
			CSVWriter testcase_writer = new CSVWriter(new FileWriter("/home/abhijeet/Desktop/MU/MUTestcases_TargetProcess/converted.csv"));
			while((nextLine = testcase_reader.readNext()) != null)
			{
				if(j==0)
				continue;
				else
				{
				   String test_name = nextLine[2];
				   String steps = nextLine[3];
				   String success = nextLine[4];
				   
				   String[] file_header = {"ProjectID","Entity Type",
				   List <String> tcline = new ArrayList<String>();
				   tcline.add(String.valueOf(obj.project_id));
				   tcline.add(Entity)
				   
				}
				j++;
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		


	}

}
