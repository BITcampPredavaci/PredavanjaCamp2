package ba.bitcamp.lectures.threads.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Thread that iterates lines in file and collects those containing search term.
 * 
 * @author emir
 *
 */
public class FileSearch extends Thread {
	private File file;
	private String word;
	
	LinkedList<String> matchingLines;
	boolean started, finished;

	public FileSearch(File file, String word) {
		this.file = file;
		this.word = word;
		this.matchingLines =  new LinkedList<String>();
	}
	
	@Override
	public void run() {
		started = true;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
				lineNum++;
				// simulate long running search by adding sleep
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (line.toLowerCase().contains(word)) {
					matchingLines.add(lineNum + ": " + line.trim());
				}
			}
		} catch (IOException e) {
			System.err.println("Error executing find: " + e.getMessage());
		}
		finished = true;
	}
	
	public LinkedList<String> getMatchingLines() {
		return matchingLines;
	}
	
	public boolean isSearchStarted() {
		return started;
	}
	
	public boolean isSearchFinished() {
		return finished;
	}
	
	public String getFilePath() {
		return file.getAbsolutePath();
	}
}
