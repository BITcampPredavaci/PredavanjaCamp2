package ba.bitcamp.lectures.recommend.data;

import java.io.IOException;

public interface LikesWriter {
	void write(Likes likes) throws IOException;
}
