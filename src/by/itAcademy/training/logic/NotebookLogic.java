package by.itAcademy.training.logic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import by.itAcademy.training.bean.Line;
import by.itAcademy.training.bean.Notebook;

public class NotebookLogic {
	//Notebook notebook = new Notebook ();
	
	public  ArrayList <Line> readDataFromFile (File file) throws IOException, ParseException {
		FileReader fr = new FileReader(file);
		Line line = new Line ();
		StringBuffer sb = new StringBuffer ();
		ArrayList <Line> lines = new ArrayList<>();
		int counterLine;
		counterLine = 0;

		while (fr.ready()) {
			char c = (char)fr.read();
			
			if (c == ';') {
				String format = "EEEE MMM d HH:mm:ss z yyyy";
				String value = sb.toString();
				Calendar calendar = GregorianCalendar.getInstance();
				calendar.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value));
				line.setDateOfCreation(calendar);
				sb = new StringBuffer ();
			} else if (c == '\n') {
				sb.deleteCharAt(0);
				line.setString(sb.toString());
				sb = new StringBuffer ();
				lines.add(counterLine, line);
				counterLine++;
				line = new Line ();
			} else {
				sb.append(c);
			}
		}
		fr.close();
		
		Notebook.setNotebook(lines);
		return Notebook.getNotebook();
		
	}
	
	public void addLineInFile (File file, String string) throws IOException, ParseException {
		readDataFromFile(file);
		ArrayList <Line> lines = Notebook.getNotebook();
		
		Line newLine = new Line (string);
		lines.add(lines.size(), newLine);
		
		FileWriter fw = new FileWriter (file);
		for (int i = 0; i < lines.size(); i++) {
			fw.write(lines.get(i) + "\n");
		}
		fw.flush();
		fw.close();
	}
	
	public void deleteLineFromFile (File file, int linenumber) throws IOException, ParseException {
		readDataFromFile(file);
		ArrayList <Line> lines = Notebook.getNotebook();
		lines.remove(linenumber - 1);
		
		FileWriter fw = new FileWriter (file);
		for (int i = 0; i < lines.size(); i++) {
			fw.write(lines.get(i) + "\n");
		}
		fw.flush();
		fw.close();
	}
	
	public ArrayList <Line> findLineByContent (File file, String content) throws IOException, ParseException {
		readDataFromFile(file);
		ArrayList <Line> lines = Notebook.getNotebook();
		
		ArrayList <Line> linesContent = new ArrayList<>();
		
		for (int i = 0, j = 0; i < lines.size(); i++) {
			if ( lines.get(i).getString().contains(content) ) {
				linesContent.add(j, lines.get(i));
				j++;
			}
		}
		
		return linesContent;
	}
	
	
	public ArrayList <Line> findLineByDate (File file, String dataString) throws IOException, ParseException {
		readDataFromFile(file);
		ArrayList <Line> lines = Notebook.getNotebook();

		int dayOfMonthUser = Integer.parseInt(dataString.substring(0, 2));
		int monthUser = Integer.parseInt(dataString.substring(3, 5)) - 1;
		int yearUser = Integer.parseInt(dataString.substring(6, dataString.length()));
		
		ArrayList <Line> linesContent = new ArrayList<>();
	
		for (int i = 0, j = 0; i < lines.size(); i++) {
			if (dayOfMonthUser == lines.get(i).getDateOfCreation().get(Calendar.DAY_OF_MONTH) &
					monthUser == lines.get(i).getDateOfCreation().get(Calendar.MONTH) &
					yearUser == lines.get(i).getDateOfCreation().get(Calendar.YEAR)) {
				linesContent.add(j, lines.get(i));
				j++;
			} 
		}
		
		return linesContent;
	}

}
