package ba.bitcamp.lectures.i18n.helloworld;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class HelloWorldPseudoI18n {
//	public static String[] text_bs = new String[] {"Pozrav svijetu!!!", "Unesi broj: "};
//	public static String[] text_en = new String[] {"Hello world!!!", "Enter number: "};
	private static final String HELLO = "hello"; 
	private static final String ENTER_NUM = "num"; 
	
	private static Map<String, String> text_en = new HashMap<String, String>() {{
		put(HELLO, "Hello world!!!");
		put(ENTER_NUM, "Enter number: ");
	}};

	private static Map<String, String> text_bs = new HashMap<String, String>() {{
		put(HELLO, "Pozdrav svijetu!!!");
		put(ENTER_NUM, "Unesi broj: ");
	}};
	
	private static Map<String, Map<String, String>> supportedLanguages = new HashMap<String, Map<String,String>>() {{
		put("en", text_en);
		put("bs", text_bs);
	}};
	
	public static void main(String[] args) {
		Map<String, String> text = null;
		if (args.length == 1) {
			text = supportedLanguages.get(args[0]);
			if (text == null) {
				throw new RuntimeException("Unsupported language " + args[0]);
			}
		} else {
			text = text_en;
		}
		
		System.out.println(text.get(HELLO));
		System.out.println(text.get(ENTER_NUM));
		Scanner in = new Scanner(System.in);
		String br = in.nextLine();
		try {
			double parsed = Double.parseDouble(br);
			if (parsed > 123456) {
				System.out.println("Broj je veci od 123456");
			} else {
				System.out.println("Broj je manji (ili jednak) od 123456");
			}
		} catch (NumberFormatException e) {
			System.err.println(br  + " nije broj");
		}
		in.close();
	}
}
