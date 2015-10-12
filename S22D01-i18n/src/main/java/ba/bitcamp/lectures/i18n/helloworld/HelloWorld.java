package ba.bitcamp.lectures.i18n.helloworld;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.Scanner;


public class HelloWorld {
	public static double REF_NUM = 123789;
	
	public static void main(String[] args) {
		
		Locale locale = null;
		if (args.length == 1) {
			locale = new Locale(args[0]);
//			locale = new Locale.Builder().setLanguage(args[0]).build();
		} else {
//			locale = Locale.GERMAN;
			locale = Locale.getDefault();
		}
		
		System.out.println("Locale: " + locale.toString());
		DateFormat dateTime = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		System.out.println(dateTime.format(new Date()));
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		System.out.println(bundle.getString("HELLO"));
		System.out.println(bundle.getString("ENTER_NUM"));
		Scanner in = new Scanner(System.in);
		String br = in.nextLine();
		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance(locale);
			double parsed = numFormat.parse(br).doubleValue();
			MessageFormat msg = new MessageFormat("", locale);
			if (parsed > REF_NUM) {
				msg.applyPattern(bundle.getString("NUM_GREATER"));
			} else {
				msg.applyPattern(bundle.getString("NUM_SMALLER"));
			}
			System.out.println(msg.format(new Object[] {REF_NUM, parsed, new Date()}));
		} catch (ParseException e) {
			System.err.println(br  + " nije broj"); //$NON-NLS-1$
		}
		in.close();
		
		ListResourceBundle gbBundle = (ListResourceBundle) ListResourceBundle.getBundle(Goodbye.class.getName(), locale);
		System.out.println(gbBundle.getObject("language"));
		
	}
}
