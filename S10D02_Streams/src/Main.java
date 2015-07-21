import java.io.*;
import java.util.Scanner;

public class Main {
	
	private static void printByteArray(byte[] array){
		for(byte b : array){
			System.out.print((char)b);
		}
		System.out.println();
	}
	
	private static void partI(){
		InputStream is = null;
		OutputStream os = null;
		try {
			is = System.in; //new FileInputStream("nesto.txt");
			os = new FileOutputStream("nesto.txt", true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
		
		Reader r = new InputStreamReader(System.in);
		Writer w = new OutputStreamWriter(System.out);
		
		BufferedReader br = new BufferedReader(r);
		BufferedWriter bw = new BufferedWriter(w);
		

		byte[] buffer = new byte[3];

		try {
			int read = 0;
			do{
				read = is.read(buffer) ;
				os.write(buffer, 0, read);
			}while( is.available() > 0);
			
			String message = "Hello World";
		    buffer = message.getBytes();
		    
		    os.write(buffer);
			
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Gotovo");
	}

	
	private static void partII(){
		InputStream is = null;
		OutputStream os = System.out;
		try {
			is = new FileInputStream("nesto.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reader r = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(r);
		
		PrintWriter pw = new PrintWriter(System.out);
		
		String line = null;
		
		try {
			while( (line = br.readLine()) != null ){
				pw.println(line);
			}
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		pw.close();
	}
	
	
	public static void main(String[] args) {

		User u = new User("John", 26);
		
		OutputStream os;
		try {
			os = new FileOutputStream("user.dat", true);
			InputStream is = new FileInputStream("user.dat");
			ObjectOutputStream osw = new ObjectOutputStream(os);
			osw.writeObject(u);
			
			ObjectInputStream ois = new ObjectInputStream(is);
			User fromFile = (User)ois.readObject();
			
			BufferedReader br = new BufferedReader(
					new Reader(
				  new InputStreamReader(System.in);			
				)
					
					);
			
			System.out.println(fromFile);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
