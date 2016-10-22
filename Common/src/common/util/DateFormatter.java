package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	private static DateFormatter formatter;
	private SimpleDateFormat sdf;

	private DateFormatter() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}
	
	public static DateFormatter getDateFormatter() {
		if (formatter == null) {
			formatter = new DateFormatter();
		}
		return formatter;
	}
	
	public Date parse(String dateStr) {
		Date date = null;
		try {
			date =  sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
