package ba.bitcamp.lectures.recommend.data;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Randomizer implements Iterable<Likes>, Closeable {
	private int movies;
	private byte maxLike;

	private BufferedReader reader;
	private String next;
	
	private Random rand = new Random();

	public Randomizer(InputStream names, int movies, byte maxLike) {
		this.movies = movies;
		this.maxLike = maxLike;
		this.reader = new BufferedReader(new InputStreamReader(names));
		this.next = nextLine();
	}

	private String nextLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Wrapping is not good!!!", e);
		}
	}

	@Override
	public Iterator<Likes> iterator() {
		return new Iterator<Likes>() {

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public Likes next() {
				if (next != null) {
					int[] likes = new int[movies];
					int watched = rand.nextInt(movies / 2);
					for (int i=0; i<watched; i++) {
						likes[rand.nextInt(likes.length)] = rand.nextInt(maxLike);
					}
					String name = next;
					next = nextLine();
					return new Likes(name, likes);
				}
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Remove not supported");
			}
		};
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}
	
	
}
