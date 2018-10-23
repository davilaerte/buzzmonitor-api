package buzzmonitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date dataParse(String date){
		Date newDate = null;
		try {
			if (date != null) {
				newDate = df.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return newDate;
	}
	
	public static String dateFormat(Date date) {
		String newDate = null;
		
		if (date != null) {
			newDate = df.format(date);	
		}
		
		return newDate;	
	}
}
