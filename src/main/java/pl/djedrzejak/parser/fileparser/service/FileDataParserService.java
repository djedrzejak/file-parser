package pl.djedrzejak.parser.fileparser.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.djedrzejak.parser.fileparser.enums.FileExtension;
import pl.djedrzejak.parser.fileparser.model.Person;
import pl.djedrzejak.parser.fileparser.parsers.Parser;

@Service
public class FileDataParserService {

	public static final String FILE_PATH = "src/main/resources/files/Workbook2";
	
	private Parser prnParser;
	private Parser csvParser;
	private BufferedReader br;
	private String extension;
	
	public FileDataParserService(@Qualifier("prnParserImpl") Parser prnParser, @Qualifier("csvParserImpl")Parser csvParser) {
		this.prnParser = prnParser;
		this.csvParser = csvParser;
	}
	
	public List<Person> getCsvData() {
		extension = FileExtension.CSV.toString();
		try {
			br = new BufferedReader(new FileReader(FILE_PATH + "." + extension));
			return getDataFromFile(br, extension, csvParser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Person> getPrnData() {
		extension = FileExtension.PRN.toString();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH + "." + extension), "UTF8"));
			return getDataFromFile(br, extension, prnParser);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<Person> getDataFromFile(BufferedReader br, String extension, Parser parser) throws Exception {
		List<Person> people = new ArrayList<Person>();
		String line;
		Person person;
		
		br.readLine();
		while((line = br.readLine()) != null) {
			person = parser.parseTextLineToPerson(line);
			person.setFileExtension(extension);
			people.add(person);

		}
		return people;
	}
}
