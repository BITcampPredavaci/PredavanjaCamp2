package ba.bitcamp.lectures.recommend.data;

import java.util.Arrays;

public class Likes {
	String name;
	int[] likes;
	
	public Likes(String name, int[] likes) {
		this.name = name;
		this.likes = likes;
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getLikes() {
		return likes;
	}
	
	@Override
	public String toString() {
		return name + ":" + Arrays.toString(likes);
	}
}
