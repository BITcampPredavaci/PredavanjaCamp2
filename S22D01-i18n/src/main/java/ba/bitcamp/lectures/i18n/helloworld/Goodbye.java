package ba.bitcamp.lectures.i18n.helloworld;
import java.util.ListResourceBundle;


public class Goodbye extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][]{new Object[]{"language", "NO FLAG"}};
	}

}
