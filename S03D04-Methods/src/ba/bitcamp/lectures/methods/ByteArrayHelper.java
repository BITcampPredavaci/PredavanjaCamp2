package ba.bitcamp.lectures.methods;

/**
 * Utility class containing methods for manipulating byte array
 * @author emir
 *
 */
public class ByteArrayHelper {
	public static void zamijeniMjesta(byte[] niz, int idx1, int idx2) {
		byte tmp = niz[idx1];
		niz[idx1] = niz[idx2];
		niz[idx2] = tmp;
	}
}
