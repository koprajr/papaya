package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm";
	public static final String DATE_FORMAT_W_SECONDS = "MM/dd/yyyy HH:mm:ss";

	public static long timeStampToEpochTime(String timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		try {
			Date date = sdf.parse(timeStamp);
			return date.getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	public static String epochTimeToTimeStamp(long epochTime){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_W_SECONDS);
		return sdf.format(new Date(epochTime));
	}
}
