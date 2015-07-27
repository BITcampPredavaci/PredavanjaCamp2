package ba.bitcamp.lectures.networking.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that demo initialization of URL class. 
 * It uses {@link URLUtils} to retrieve content.
 * @author emir
 *
 */
public class URLTest {
	public static void main(String[] args) {
		try {
			// web resource - http protocol
			URL abhUrl = new URL("http://atlantbh.com");
			System.out.println(URLUtils.toString(abhUrl));
			
			// local resource - file protocol
			String homeDir = System.getProperty("user.dir");
			URL homeDirURL = new URL("file://" + homeDir);
			URL someFileUrl = new URL(homeDirURL, "S11D01-Networking/someFile.txt");
			System.out.println(someFileUrl);
			System.out.println(URLUtils.toString(someFileUrl));
			
			// raw response with socket
			System.out.println(URLUtils.toStringSocket("http://atlantbh.com/services"));
		} catch (MalformedURLException e) {
			System.err.println("URL not ok!!!");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
