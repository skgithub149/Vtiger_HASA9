package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods of java
 * @author DHARMENDRA KUMAR
 *
 */
public class JavaUtility {
	/**
	 * This method generate random number
	 * @return
	 */
	public int generateRandomNumber() {
		Random random=new Random();
		return random.nextInt();
	}
	
	/**
	 * This method is used to fetch current date and time
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}

}
