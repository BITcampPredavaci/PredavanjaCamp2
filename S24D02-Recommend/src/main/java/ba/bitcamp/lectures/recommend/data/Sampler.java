package ba.bitcamp.lectures.recommend.data;

import java.io.IOException;
import java.io.InputStream;

public class Sampler {
	public static void main(String[] args) throws IOException {
		InputStream names = Sampler.class.getResourceAsStream("/names.txt");
		int movies = 100;
		byte maxLike = 10;
		
		String csvTarget = "src/main/resources/likes.csv";
		String binTarget = "src/main/resources/likes.bin";
		
		try (Randomizer likes = new Randomizer(names, movies, maxLike); 
			CSVLikesWriter csv = new CSVLikesWriter(csvTarget);
			BinaryLikesWriter bin = new BinaryLikesWriter(binTarget)) {
			for (Likes like : likes) {
				csv.write(like);
				bin.write(like);
			}
			System.out.println("Sampling done!");
		}
	}
}
