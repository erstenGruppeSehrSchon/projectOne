package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	private static DateFormatter formatter;
	private SimpleDateFormat dateFormat;
	private SimpleDateFormat timeFormat;

	private DateFormatter() {
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		timeFormat = new SimpleDateFormat("HH:mm");
	}
	
	public static DateFormatter getDateFormatter() {
		if (formatter == null) {
			formatter = new DateFormatter();
		}
		return formatter;
	}
	
	public Date parseDate(String dateStr) {
		Date date = null;
		try {
			date =  dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public Date parseTime(String dateStr) {
		Date date = null;
		try {
			date =  timeFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
