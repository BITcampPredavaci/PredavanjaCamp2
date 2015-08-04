package ba.bicamp.benjamin.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStreamSample {

	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("myfile.txt");
			
			FileOutputStream os = new FileOutputStream("myfile.txt");
			
			PrintWriter pw = new PrintWriter(os);
			
			
		
			
			byte[] buffer = new byte[5];
			while(is.available() > 0){
				is.read(buffer);
				for(byte b : buffer){
					System.out.print(b + " ");
				}
				//buffer = new byte[10];
			}
			
			pw.println("Moj string");
			pw.printf("Moj %s formatirani", "string");
			pw.print(true);
			pw.print(2.45);
			pw.flush();
			pw.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
