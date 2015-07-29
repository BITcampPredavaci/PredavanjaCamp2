import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
	
	private static int PORT = 7321;

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			
			while(true){
				Socket client = server.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				String line = "";
				String requestType = "";
				String requestRoute = "";
				while((line = br.readLine()) != null){
					if(line.contains("GET") 
							|| line.contains("POST")){
						String[] parts = line.split(" ");
						requestType = parts[0];
						requestRoute = parts[1];
						break;
					}
				}
				
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				
				try {
					String htmlContent = FileHandler.getContent(requestRoute);
					Result.ok(bw, htmlContent);
				} catch (FileNotFoundException e){
					Result.notFound(bw);
				} catch (IOException e){
					Result.serverError(bw);
				}
				
				bw.flush();
				
				client.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
