package ba.bitcamp.lectures.threads.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Main thread is responsible for interacting with user. 
 * Similar to swing's event handler thread it should not have any long running tasks
 * in order to keep our app responsive.
 * This is only thread that access System.out so there is no need to sync access.
 * 
 * @author emir
 *
 */
public class Search {
	private static Map<String, SearchTask> tasks = new HashMap<String, SearchTask>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean run = true;
		System.out.println("Find program; Current dir: " + System.getProperty("user.dir"));
		do {
			System.out.print(">>");
			String commandLine = in.nextLine().trim();
			if (!commandLine.isEmpty()) {
				String[] params = commandLine.split(" ");
				switch (params[0].toLowerCase()) {
				case "exit":
					run = false;
					break;
				case "find":
					// usage: find searchWord searchPath
					// example: find system .
					// finds lines containing "system" in all files in current directory and subdirectories 
					find(params);
					break;
				case "status":
					// usage: status tastId
					// example: status 1
					status(params);
					break;
				default:
					System.out.println("Unrecognized command " + params[0]);
				}
			}
		} while (run);
		in.close();
		System.out.println("Done!");
	}

	private static void find(String[] params) {
		String word = params[1];
		String filePath = params[2];
		SearchTask task = new SearchTask(filePath, word);
		String taskId = storeTask(task);
		task.start();
		System.out.println("Started task with id: " + taskId);
	}
	
	private static void status(String[] params) {
		String taskId = params[1];
		SearchTask task = tasks.get(taskId);
		
		if (task != null) {
			for (FileSearch fileSearch : task) {
				System.out.println("File: " + fileSearch.getFilePath());
				System.out.println("Started: " + fileSearch.isSearchStarted());
				System.out.println("Finished: " + fileSearch.isSearchFinished());
				LinkedList<String> lines = fileSearch.getMatchingLines();
				if (lines.isEmpty()) {
					System.out.println("No matching lines");
				} else {
					System.out.println("Line Matches: ");
					for (String line : lines) {
						System.out.println("\t" + line);
					}
				}
			}
		} else {
			System.out.println("Task does not exist");
		}
	}
	
	
	private static int taskIdCounter = 0;
	private static String storeTask(SearchTask task) {
		// no need to synchronize id increment since this is only thread that access this
		String taskId = String.valueOf(taskIdCounter++);
		tasks.put(taskId, task);
		return taskId;
	}
}
