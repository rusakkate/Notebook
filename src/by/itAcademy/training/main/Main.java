package by.itAcademy.training.main;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import by.itAcademy.training.configuration.Configuration;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		File file = new File ("Notebook.txt");
		Configuration.workNotebook(file);
	}
}
