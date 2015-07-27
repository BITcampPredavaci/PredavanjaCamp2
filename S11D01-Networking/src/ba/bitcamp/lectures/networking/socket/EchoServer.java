package ba.bitcamp.lectures.networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Demo simple server component that listens on port 12345 and 
 * for any accepted connection reads first line of request and echoes it back after sending OK.
 * 
 * @author emir
 *
 */
public class EchoServer {
	public static final int ECHO_PORT = 12345;
	public static void main(String[] args) throws IOException {
		// open server socket on unused port
		try (ServerSocket server = new ServerSocket(ECHO_PORT)) {
			// service loop
			while (true) {
				System.out.println("Waiting for next attempt to connect...");
				// accept one connection at a time
				try (Socket connection = server.accept()) {
					// process connection using socket for communicating with client
					handleRequest(connection);
				}
			}
		}
	}
	private static void handleRequest(Socket connection) throws IOException {
		// read input stream to get request command from client
		System.out.println("Request accepted, wating for request command...");
		InputStream rqStream = connection.getInputStream();
		OutputStream respStream = connection.getOutputStream();
		BufferedReader rqReader = new BufferedReader(new InputStreamReader(rqStream));
		String rq = rqReader.readLine();
		
		System.out.println("Request command: " + rq);
		System.out.println("Writing response...");
		
		// write response to output stream
		OutputStreamWriter writer = new OutputStreamWriter(respStream);
		writer.write("OK\n");
		writer.write(rq);
		writer.flush();
		System.out.println("Response flushed, closing connection...");
	}
}
