package question_20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


	public class ReadFile {
	       
		public boolean ReadFile(File file) throws IOException {
	            BufferedReader br = null;
	            if(!file.exists()) {
	            	System.out.println("Warning!" + '\n' + "file does not exist.");
	            	return false;
	            }
	            try{
	                br = new BufferedReader(new FileReader("Sampler/Data.txt"));
	                String line;
	                while((line = br.readLine()) != null){

	                    String[] data = line.split(":");

	                    System.out.println("Name: "+data[0]+" "+data[1]);
	                    System.out.println("Age: "+ data[2]+" years");
	                    System.out.println("State: "+ data[3]+" State");
	                    System.out.println("\n");
	                }
	               
	            } catch(IOException e) {
	                e.printStackTrace();
	                
	            }finally{
	            	
	                if(br != null){
	                    br.close();
	                }
	            }
				return true;
	        }
}




