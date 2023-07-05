package ex.api.system.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			// FUNÇÃO PROPRIA DO JAVA, UTILIZADA PARA DECODIFICAÇÃO, PADRÃO MAIS USADO ATUALMENTE "UTF-8"
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return ""; // CASO OCORRA ERRORS
		}
	}
	
// CONVERTENDO A DATA PARA STRING	
	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // FORMATO DA DATA
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // TIMEZONE
		try {
			return sdf.parse(textDate); // CONVERTENDO
		} catch (ParseException e) {
			return defaultValue;
		}		
	}
	
}
