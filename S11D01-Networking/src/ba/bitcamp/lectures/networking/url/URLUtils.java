package ba.bitcamp.lectures.networking.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class URLUtils {
	/**
	 * Retrieves String representation of resource referenced with URL.
	 * @param url
	 * @return String representation or resource or null if resource is not text/*
	 * @throws IOException
	 */
	public static String toString(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		String contentType = conn.getContentType();
		if (contentType != null && contentType.toLowerCase().startsWith("text")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append('\n');
			}
			in.close();
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * Retrives String representation of response using Socket. 
	 * It is simplification of what URL class does.
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String toStringSocket(String url) throws IOException {
		if (url.startsWith("http://")) {
			// you can use URL to parse this request, but this is completely URL free
			int hostStart = "http://".length();
			int hostEnd = url.indexOf('/', hostStart + 1);
			
			String host = hostEnd > 0 ? url .substring(hostStart, hostEnd) : url.substring(hostStart);
			String path = hostEnd > 0 ? url.substring(hostEnd) : "/";
			
			// socket inside try - will automatically be closed when finished or on exception
			System.out.println("Host: " + host);
			System.out.println("Path: " + path);
			try (Socket socket = new Socket(host, 80)) { 
				OutputStreamWriter req = new OutputStreamWriter(socket.getOutputStream());
				req.write("GET ");
				req.write(path);
				req.write(" HTTP/1.1\r\n");
				req.write("Host: ");
				req.write(host);
				req.write("\r\n\r\n");
				req.flush();
				
				// collect raw response - contains headers as well; does not check content type
				InputStream resp = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(resp));
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line).append('\n');
				}
				return sb.toString();
			}
		}
		return null;
	}
}
