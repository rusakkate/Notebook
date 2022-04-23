package by.itAcademy.training.configuration;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import by.itAcademy.training.Interface.Menu;
import by.itAcademy.training.Interface.UserEnter;
import by.itAcademy.training.Interface.View;
import by.itAcademy.training.logic.NotebookLogic;

public class Configuration {
	
	public static void workNotebook (File file) throws IOException, ParseException {
		Menu.StartMenu();
		
		int userChoice = UserEnter.inputInt("", Menu.NUMPOINTSTARTMENU);
		
		NotebookLogic notebookLogic = new NotebookLogic();
		
		switch (userChoice) {
		case 1:
			notebookLogic.addLineInFile(file, UserEnter.inputString("Enter line"));
			View.printResult("New line has been wrote in notebook");
			Configuration.choiseContinueOrFinishWork(file);
			break;
		case 2:
			View.printArray(notebookLogic.findLineByDate(file, UserEnter.inputString("Enter date in formate dd.mm.yyyy")), "Notes created on the specified date: ");
			Configuration.choiseContinueOrFinishWork(file);
			break;
		case 3:
			View.printArray(notebookLogic.findLineByContent(file, UserEnter.inputString("Enter content")), "Notes containing the entered text: ");
			Configuration.choiseContinueOrFinishWork(file);
			break;
		case 4:
			notebookLogic.deleteLineFromFile(file, UserEnter.inputInt("Enter line's number for deleting", notebookLogic.readDataFromFile(file).size())); 
			View.printResult("Line has been removed from the file");
			Configuration.choiseContinueOrFinishWork(file);
			break;
		}
	}
	
	public static void choiseContinueOrFinishWork (File file) throws IOException, ParseException {
		Menu.ContinueMenu();
		
		int userChoice = UserEnter.inputInt(null, Menu.NUMPOINTCONTINUEMENU);
		
		switch (userChoice) {
		case 1:
			Configuration.workNotebook(file);
		case 2:
			View.printResult("Good bue");
		}
	}
	

}
