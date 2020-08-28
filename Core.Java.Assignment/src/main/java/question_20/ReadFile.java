package question_20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


	public class ReadFile {
		
		
	       
		public void ReadFile() throws IOException {
	            BufferedReader br = null;
	            try{
	                br = new BufferedReader(new FileReader("src/main/resources/data.txt")); //creates a new file
	                String line;
	                while((line = br.readLine()) != null){

	                    String[] data = line.split(":");

	                    System.out.println("Name: "+data[0]+" "+data[1]);   //Adds requested data into that file at txt
	                    System.out.println("Age: "+ data[2]+" years");
	                    System.out.println("State: "+ data[3]+" State");
	                    System.out.println("\n");
	                }
	            }catch(IOException ex){   
	                ex.printStackTrace();    //Throws the exception and closes the reader. 
	            }finally{
	                if(br != null){
	                    br.close();
	                }
	            }
	        }
		
		 /*public boolean FileCheck() {
			if(true) {
				final Path path = Files.notExists("src/main/resources/data.txt");
				return true;
			} else {
				final Path path = Files.exists("src/main/resources/data.txt");
			}
		}*/
}
         


