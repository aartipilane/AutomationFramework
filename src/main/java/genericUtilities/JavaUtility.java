package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This class consists of reusable methods related to Java 
 */

public class JavaUtility {

	/*
	 * This method will capture current system date and return to caller
	 * @return
	 */
	
	public static String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-mm-yy_hh-mm-ss");
		String dateInFormat = f.format(d);
		return dateInFormat;
	}
	
}
