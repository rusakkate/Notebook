package by.itAcademy.training.logic;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import org.junit.Test;
import org.junit.Assert;

import by.itAcademy.training.bean.Line;
import by.itAcademy.training.bean.Notebook;

public class NotebookLogicTest {
	
	NotebookLogic notebookLogic = new NotebookLogic();
	File fileDontChangeTest = new File ("NotebookReadDataFromFileTest.txt");
	File fileChangeTest = new File ("NotebookAddLineInFileTest.txt");
	
	@Test
	public void readDataFromFileTestSize () throws IOException, ParseException {
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileDontChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		
		int realSizeNotebook;
		int expectedSizeNotebook;
		expectedSizeNotebook = 5;
		realSizeNotebook = linesTest.size();
		
		Assert.assertEquals(expectedSizeNotebook, realSizeNotebook);
	}
	
	@Test
	public void readDataFromFileTestData () throws IOException, ParseException {
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileDontChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		
		Line expectedLine = new Line();
		Line realLine = new Line();
		
		String format = "EEEE MMM d HH:mm:ss z yyyy";
		String value = "Sat Apr 15 13:58:11 MSK 2022";
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value));
		
		expectedLine.setDateOfCreation(calendar);
		expectedLine.setString("Sofia kotik");
	
		realLine = linesTest.get(0);
		
		Assert.assertEquals(expectedLine, realLine);
	}

	@Test
	public void addLineInFileTestSize () throws IOException, ParseException {
		int expectedSizeAfterAdd;
		int realSizeAfterAdd;
		
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		
		expectedSizeAfterAdd = linesTest.size() + 1;
		
		notebookLogic.addLineInFile(fileChangeTest, "It's a test");
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		linesTest = Notebook.getNotebook();
		
		realSizeAfterAdd = linesTest.size();
		
		Assert.assertEquals(expectedSizeAfterAdd, realSizeAfterAdd);
	
	}
	
	@Test
	public void addLineInFileTestString () throws IOException, ParseException {
		int id;
		Random rand = new Random ();
		id = rand.nextInt(100);
		
		notebookLogic.addLineInFile(fileChangeTest, "It's a test" + id);
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		
		Line expectedLine = new Line();
		Line realLine = new Line();
		expectedLine.setString("It's a test" + id);
		realLine.setString( linesTest.get(linesTest.size() - 1 ).getString() );
		
		Assert.assertEquals(expectedLine.getString(), realLine.getString());
	}
	
	@Test
	public void deleteLineFromFileTestSize () throws IOException, ParseException {
		int expectedSizeAfterDelete;
		int realSizeAfterDelete;
		
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		
		expectedSizeAfterDelete = linesTest.size() - 1;
		
		notebookLogic.deleteLineFromFile(fileChangeTest, 1);;
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		linesTest = Notebook.getNotebook();
		
		realSizeAfterDelete = linesTest.size();
		
		Assert.assertEquals(expectedSizeAfterDelete, realSizeAfterDelete);
	}
	
	@Test
	public void deleteLineFromFileTestLine () throws IOException, ParseException {
		Line expectedLine = new Line();
		Line realLine = new Line();
	
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		ArrayList <Line> linesTest = Notebook.getNotebook();
		expectedLine = linesTest.get(1);
		
		notebookLogic.deleteLineFromFile(fileChangeTest, 1);
		
		Notebook.setNotebook(notebookLogic.readDataFromFile(fileChangeTest));
		linesTest = Notebook.getNotebook();
		realLine = linesTest.get(0);
		
		Assert.assertEquals(expectedLine, realLine);
	}
	
	@Test
	public void findLineByContentTest () throws IOException, ParseException {
		ArrayList <Line> expectedArray = new ArrayList<Line>();
		
		String format = "EEEE MMM d HH:mm:ss z yyyy";
		
		Line expectedLine0 = new Line ();
		String value0 = "Fri Apr 15 13:58:11 MSK 2022";
		Calendar calendar0 = GregorianCalendar.getInstance();
		calendar0.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value0));
		expectedLine0.setDateOfCreation(calendar0);
		expectedLine0.setString("Sofia kotik");
		
		Line expectedLine1 = new Line ();
		String value1 = "Sat Apr 16 13:58:11 MSK 2022";
		Calendar calendar1 = GregorianCalendar.getInstance();
		calendar1.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value1));
		expectedLine1.setDateOfCreation(calendar1);
		expectedLine1.setString("kotik may");
		
		expectedArray.add(0, expectedLine0);
		expectedArray.add(1, expectedLine1);

		ArrayList <Line> realArray = notebookLogic.findLineByContent(fileDontChangeTest, "kotik");
		
		Assert.assertEquals(expectedArray, realArray);
	}
	
	@Test
	public void findLineByDateTest () throws IOException, ParseException {
		ArrayList <Line> expectedArray = new ArrayList<Line>();
		
		String format = "EEEE MMM d HH:mm:ss z yyyy";
		
		Line expectedLine0 = new Line ();
		String value0 = "Fri Apr 15 13:58:11 MSK 2022";
		Calendar calendar0 = GregorianCalendar.getInstance();
		calendar0.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value0));
		expectedLine0.setDateOfCreation(calendar0);
		expectedLine0.setString("Sofia kotik");
		
		Line expectedLine1 = new Line ();
		String value1 = "Fri Apr 15 14:58:11 MSK 2022";
		Calendar calendar1 = GregorianCalendar.getInstance();
		calendar1.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(value1));
		expectedLine1.setDateOfCreation(calendar1);
		expectedLine1.setString("mur mur");
		
		expectedArray.add(0, expectedLine0);
		expectedArray.add(1, expectedLine1);

		ArrayList <Line> realArray = notebookLogic.findLineByDate(fileDontChangeTest, "15.04.2022");
		
		Assert.assertEquals(expectedArray, realArray);
	}
}
