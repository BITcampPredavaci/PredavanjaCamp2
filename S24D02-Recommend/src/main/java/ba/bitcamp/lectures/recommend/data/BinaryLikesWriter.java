package ba.bitcamp.lectures.recommend.data;

import java.io.IOException;

public class BinaryLikesWriter extends AbstractLikesWriter {
	public BinaryLikesWriter(String outFile) throws IOException {
		super(outFile);
	}
	
	@Override
	public void write(Likes likes) throws IOException {
		byte[] nameBytes = likes.getName().getBytes("UTF-8");
		out.write(nameBytes.length); // first byte is number of bytes in name
		out.write(nameBytes); // utf8 encoded name bytes
		out.write(likes.likes.length); // byte for number of likes
		
		for (int i=0; i<likes.likes.length; i++) {
			int res = likes.likes[i++] << 4; // encode odd likes in higher 4 bits of byte
			if (i < likes.likes.length) {
				res += likes.likes[i]; // encode even likes in lower 4 bits
			}
			out.write(res); // write two likes as single byte
		}
	}
}
