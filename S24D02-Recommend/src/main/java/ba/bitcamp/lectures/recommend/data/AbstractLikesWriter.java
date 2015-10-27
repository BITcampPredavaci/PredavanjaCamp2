package ba.bitcamp.lectures.recommend.data;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public abstract class AbstractLikesWriter implements LikesWriter, Closeable {
	protected OutputStream out;
	protected Writer writer;

	public AbstractLikesWriter(String outFile) throws IOException {
		out = new FileOutputStream(outFile);
		writer = new OutputStreamWriter(out);
	}

	@Override
	public void close() throws IOException {
		writer.close();
		out.close();
	}

}