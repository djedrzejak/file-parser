package pl.djedrzejak.parser.fileparser.parsers;

import pl.djedrzejak.parser.fileparser.model.Person;

public interface Parser {

	Person parseTextLineToPerson(String text);
	
}
