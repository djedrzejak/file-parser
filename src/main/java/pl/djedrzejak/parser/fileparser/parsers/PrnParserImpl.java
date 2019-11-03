package pl.djedrzejak.parser.fileparser.parsers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import pl.djedrzejak.parser.fileparser.model.Person;

@Component
public class PrnParserImpl implements Parser {

	@Override
	public Person parseTextLineToPerson(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		
		String name = getName(sb.toString());
		sb.replace(0, name.length(), "");
		
		String address = getAddress(sb.toString());
		sb.replace(0, address.length(), "");

		String postcode = getPostcode(sb.toString());
		sb.replace(0, postcode.length(), "");
		
		String birthday = getBirthday(sb.toString());
		sb.replace(sb.length()-birthday.length(), sb.length(), "");
		
		String creditLimit = getCreditLimit(sb.toString());
		sb.replace(sb.length()-creditLimit.length(), sb.length(), "");
		
		String phone = sb.toString();
		
		return new Person(name.trim(), 
						  address.trim(), 
						  postcode.trim(), 
						  phone.trim(), 
						  new BigDecimal(creditLimit.trim()).divide(BigDecimal.valueOf(100)), 
						  LocalDate.parse(birthday.toString(), DateTimeFormatter.ofPattern("yyyyMMdd")));
	}
	
	private String getValue(String text, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		if(m.find()) {
			return m.group();
		}
		return "";
	}
	
	private String getName(String text) {
		String pattern = "^[A-Za-z]*, [A-Za-z]*";
		return getValue(text, pattern);
	}

	private String getAddress(String text) {
		String pattern = "[^0-9]*[0-9A-Za-z]*";
		return getValue(text, pattern);
	}
	
	private String getPostcode(String text) {
		String pattern = "^[0-9 ]*[A-Za-z]*";
		return getValue(text, pattern);
	}
	
	private String getBirthday(String text) {
		String pattern = "[0-9]*$";
		return getValue(text, pattern);
	}
	
	private String getCreditLimit(String text) {
		String pattern = "[0-9]* $";
		return getValue(text, pattern);
	}

}
