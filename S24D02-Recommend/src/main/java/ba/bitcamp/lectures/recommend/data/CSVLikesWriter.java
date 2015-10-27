package ba.bitcamp.lectures.recommend.data;

import java.io.IOException;

public class CSVLikesWriter extends AbstractLikesWriter {
	public CSVLikesWriter(String outFile) throws IOException {
		super(outFile);
	}
	
	@Override
	public void write(Likes likes) throws IOException {
		writer.write(likes.getName());
		for (int rate : likes.getLikes()) {
			writer.write(',');
			writer.write(String.valueOf(rate));
		}
		writer.write('\n');
	}

}
