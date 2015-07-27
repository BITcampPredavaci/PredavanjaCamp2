package ba.bitcamp.lectures.networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Simple socket client for communicating with {@link EchoServer}.
 * @author emir
 *
 */
public class EchoClient {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = EchoServer.ECHO_PORT;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// open socket for server host/port
		System.out.println("Connecting to " + HOST + ":" + PORT);
		Socket client = new Socket(HOST, PORT);
		System.out.println("Connection established, sending request...");
		
		// use output stream to send request
		OutputStream rqStream = client.getOutputStream();
		OutputStreamWriter rqWriter = new OutputStreamWriter(rqStream);
		rqWriter.write("Hello server!!!\n");
		rqWriter.flush();
		System.out.println("Request sent waiting for response...");
		
		// use input stream to read response
		InputStream respStream = client.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(respStream));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("Finishing req/resp client program");
		
		// close socket - can use try(Socket conn = new Socket(HOST, PORT)) {...} to auto close socket
 		client.close();
	}
}
