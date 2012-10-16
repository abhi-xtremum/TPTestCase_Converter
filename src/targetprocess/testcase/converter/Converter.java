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
	    
		obj.entity_type = "TestCase";
		
		System.out.println("This converter will currently accept your test-cases in this format:");
		System.out.println("1.Description 2.Steps 3.Expected Result \n These parameters should be the 2nd, 3rd, 4th column in your testcase");
		
		try {
			
			//Creating object for CSVReader accepting the filename. Currently hard-coded.
			CSVReader testcase_reader = new CSVReader(new FileReader("/home/abhijeet/Desktop/MU/MUTestcases_TargetProcess/sample_praxifytc.csv"));
			String[] nextLine;
			int j=0;
			
			testcase_reader.readNext();
			
			
			
			CSVWriter testcase_writer = new CSVWriter(new FileWriter("/home/abhijeet/Desktop/MU/MUTestcases_TargetProcess/converted.csv"));
			String[] file_header = {"ProjectID","Entity Type","ID","Name","Last Run Date","Creation Date","Project","User Story","Last Failure Comment","Last Status","Steps","Success","Priority","Tags","Owner"};
			testcase_writer.writeNext(file_header);
			
			while((nextLine = testcase_reader.readNext()) != null)
			{
				
				   System.out.println("reading and writing..");
				  
				   
				   List <String> tclist = new ArrayList<String>();
				   tclist.add(String.valueOf(obj.project_id));
				   tclist.add(obj.entity_type);
				   tclist.add(obj.testcase_id);
				   tclist.add(nextLine[2]);
				   tclist.add(obj.last_run_date);
				   tclist.add(obj.creation_date);
				   tclist.add("US Build");
				   tclist.add(obj.user_story);
				   tclist.add(obj.lastfailure_comment);
				   tclist.add(obj.last_status);
				   tclist.add(nextLine[3]);
				   tclist.add(nextLine[4]);
				   tclist.add(obj.priority);
				   tclist.add(obj.tags);
				   
				   
				   
		   		   String[] tcline = new String[tclist.size()];
				    tcline = tclist.toArray(tcline);
         		   testcase_writer.writeNext(tcline);
				
				
			}
			
			testcase_reader.close();
			testcase_writer.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
    

	}

}
