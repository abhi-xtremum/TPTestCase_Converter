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

		// Creating object of the class so as to instantiate the string
		// variables as empty strings.
		Converter obj = new Converter();
		String input_filepath;
		String output_file;

		/*
		 * System.out.println("Enter ProjectID:\n"); BufferedReader br = new
		 * BufferedReader(new InputStreamReader(System.in)); try {
		 * obj.project_id = Integer.parseInt(br.readLine()); } catch
		 * (NumberFormatException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */

		System.out
				.println("Enter project name exactly that is in TargetProcess:\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		obj.project = br.readLine();
		obj.entity_type = "TestCase";
		

		System.out
			.println("This converter will currently accept only the below columns from your testcases. Make sure you have these columns in your testcase csv");
		System.out
			.println("1.Module 2.Description 3.Steps 3.Expected Result 4.Comment\n These parameters should be the 2nd, 3rd, 4th 5th and 6th column in your testcase");
		
		
		System.out
		 	.println("Enter the input csv file with it's absolute path:");
		input_filepath = br.readLine();
		
		System.out
			.println("Enter the output filename with it's absolute path:");
		output_file = br.readLine();
		
	    

		try {

			// Creating object for CSVReader accepting the filename.
			CSVReader testcase_reader = new CSVReader(new FileReader(input_filepath));
			String[] nextLine;
			
			testcase_reader.readNext();

			CSVWriter testcase_writer = new CSVWriter(
					new FileWriter(output_file));
			
			//Creating the header for the output file that goes into TargetProcess
			String[] file_header = { "ProjectID", "Entity Type", "ID", "Name",
					"Last Run Date", "Creation Date", "Project", "User Story",
					"Last Failure Comment", "Last Status", "Steps", "Success",
					"Priority", "Tags", "Owner" };
			
			//Writing the header as first line in the output file.
			testcase_writer.writeNext(file_header);

			while ((nextLine = testcase_reader.readNext()) != null) {

				System.out.println("reading and writing..");

				List<String> tclist = new ArrayList<String>();
				tclist.add(String.valueOf(obj.project_id));
				tclist.add(obj.entity_type);
				tclist.add(obj.testcase_id);
				tclist.add(nextLine[2]);
				tclist.add(obj.last_run_date);
				tclist.add(obj.creation_date);
				tclist.add(obj.project);
				tclist.add(obj.user_story);
				tclist.add(obj.lastfailure_comment);
				tclist.add(obj.last_status);
				tclist.add(nextLine[3]);
				tclist.add(nextLine[4]);
				tclist.add(obj.priority);
				obj.tags = nextLine[1];
				tclist.add(obj.tags);
				tclist.add(obj.owner);

				String[] tcline = new String[tclist.size()];
				tcline = tclist.toArray(tcline);
				testcase_writer.writeNext(tcline);

			}

			testcase_reader.close();
			testcase_writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Sorry, your file does not exist in the given path or your path is invalid.");
		}

	}

}
