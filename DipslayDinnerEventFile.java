import java.nio.file.*;
import java.util.Scanner;
import java.io.*;

public class DipslayDinnerEventFile {

	public static void main(String[] args) {
		// get path and file name from user, since if program runs another computer path may not exist.
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.println("Please Enter File Location and Name: ");
				String userPath = input.nextLine();
				
				// set file path from user
				Path file = Paths.get(userPath);
				
				// variables for file output
				InputStream inputStream;
				BufferedReader reader;
				
				// variables for storing the string
				String store;
			
				//try catch block to see if file can be created and written to. If not throw error then display Java error to diagnose issue.
				try
				{
					// create file input and reader
					inputStream = Files.newInputStream(file);
					reader = new BufferedReader(new InputStreamReader(inputStream));
					
					// loop through file and store each line into a string					
					while((store= reader.readLine()) != null)
					{
						//output string to console
						System.out.println(store);			
						
					}				
													
				} catch (Exception e) 
				{
					// TODO: handle exception			
					System.out.println("ERROR: " + e);
				}		
				
			}

	}
