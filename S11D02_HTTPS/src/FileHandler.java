import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileHandler {
	
	private static final String PATH_TO_PUBLIC = "./public";
	
	public static String getContent(String route) throws FileNotFoundException, IOException{
		String fullPath = routeBuilder(route);
		BufferedReader br = new BufferedReader(new FileReader(fullPath));
		
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		
		return sb.toString();
	}
	
	private static String routeBuilder(String route){
		if(route.equals("/")){
			route = "/index.html";
		}
		return PATH_TO_PUBLIC + route;
	}

}
