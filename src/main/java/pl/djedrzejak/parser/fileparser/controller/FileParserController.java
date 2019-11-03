package pl.djedrzejak.parser.fileparser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.djedrzejak.parser.fileparser.model.Person;
import pl.djedrzejak.parser.fileparser.service.FileDataParserService;

@Controller
public class FileParserController {

	private FileDataParserService fileDataParserService;
	private List<Person> people;
	
	public FileParserController(FileDataParserService fileDataParserService) {
		this.fileDataParserService = fileDataParserService; 
	}
	
	@GetMapping("/")
	public String getMainPage(Model model) {
		people = new ArrayList<Person>();
		people.addAll(fileDataParserService.getPrnData());
		people.addAll(fileDataParserService.getCsvData());
		model.addAttribute("people", people);
		return "index";
	}
	
}
