package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utility {

	public int getAge(int year, int month, int day) {

        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a;         

        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(year, month, day);
        a = y - cal.get(Calendar.YEAR);
        if ((m < cal.get(Calendar.MONTH))
                        || ((m == cal.get(Calendar.MONTH)) && (d < cal
                                        .get(Calendar.DAY_OF_MONTH)))) {
                --a;
        }
        if(a < 0)
                throw new IllegalArgumentException("Age < 0");
        return a;
    }
	
}
