package ba.bitcamp.lectures.concurrency.declarations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeclarationCounter {
	private static final String DECLARATION_REGEX = "(?:(?:private|protected|public)\\s+)?(?:static\\s+)?(?:final\\s+)?([^-+\\s]+)\\s+(?:[^-+\\s]+)\\s*(?:;|=.*)";
	private static final Pattern DECLARATION_PATTERN = Pattern.compile(DECLARATION_REGEX);
	private String path;

	public DeclarationCounter(String path) {
		this.path = path;
	}
	
	public void count(Map<String, Integer> counts) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = null;
			while((line = br.readLine()) != null) {
				line = line.trim();
				// min declaration is "T a;"
				if (line.length() > 3) {
					Matcher m = DECLARATION_PATTERN.matcher(line);
					if (m.matches()) {
						String type = m.group(1);
						synchronized (counts) {
							Integer typeCount = counts.get(type);
							if (typeCount == null) {
								typeCount = 1;
							} else {
								typeCount += 1;
							}
							counts.put(type, typeCount);
						}
					}
				}
			}
		}
	}
	
	public Map<String, Integer> count() throws IOException {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		count(counts);
		return counts;
	}
}
