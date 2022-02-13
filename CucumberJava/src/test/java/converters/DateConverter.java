package converters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.Transformer;

public class DateConverter extends Transformer<Date>{
	/*
	 * pega a string e se tiver
	 * no padrão definido no format
	 * vai conseguir transformar no date
	 * 
	 */
	@Override
	public Date transform(String value) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date returnDate = format.parse(value);
			return returnDate;
		} catch (ParseException e) {
			return null;
		} 							
	}

}
