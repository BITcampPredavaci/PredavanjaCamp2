package ba.bitcamp.lectures.threads.search;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Thread that browse directory tree and starts {@link FileSearch} threads for each
 * file that is found.
 * 
 * @author emir
 *
 */
public class SearchTask extends Thread implements Iterable<FileSearch> {
	private String path;
	private String word;

	private LinkedList<FileSearch> fileSearches = new LinkedList<FileSearch>();
	
	public SearchTask(String path, String word) {
		this.path = path;
		this.word = word;
	}
	
	@Override
	public void run() {
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				findInDirectory(file, word);
			} else {
				findInFile(file, word);
			}
		} else {
			System.err.println("File does not exist: " + file.getAbsolutePath());
		}
	}
	
	@Override
	public Iterator<FileSearch> iterator() {
		return fileSearches.iterator();
	}


	private void findInDirectory(File dir, String word) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				findInDirectory(file, word);
			} else {
				findInFile(file, word);
			}
		}
	}
	
	private void findInFile(final File file, final String word) {
		FileSearch fileSearch = new FileSearch(file, word);
		fileSearches.add(fileSearch);
		fileSearch.start();
	}

}
