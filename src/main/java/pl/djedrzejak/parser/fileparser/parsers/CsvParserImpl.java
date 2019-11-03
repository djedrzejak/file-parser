package pl.djedrzejak.parser.fileparser.parsers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import pl.djedrzejak.parser.fileparser.model.Person;

@Component
public class CsvParserImpl implements Parser {

	@Override
	public Person parseTextLineToPerson(String text) {
		String[] data = text.split(",(?=([^\"]|\"[^\"]*\")*$)");
		return new Person(removeQuotes(data[0]), 
						  data[1], 
						  data[2], 
						  data[3], 
						  new BigDecimal(data[4]), 
						  LocalDate.parse(data[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	private String removeQuotes(String text) {
		return text.replaceAll("\"", "");
	}
	
}
