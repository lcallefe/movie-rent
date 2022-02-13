package converters;

import cucumber.api.Transformer;

public class DoubleConverter extends Transformer<Double> {

	@Override
	public Double transform(String value) {
		double str = Double.parseDouble(value);
		return str;
	}	

}
