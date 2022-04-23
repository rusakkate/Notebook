package by.itAcademy.training.bean;

import java.util.ArrayList;
import java.util.Objects;

public class Notebook {
	
	private static ArrayList <Line> notebook = null;

	private Notebook() {
		
	}

	public static ArrayList<Line> getNotebook() {
		if (notebook == null) {
			notebook = new ArrayList<>();
		}
		return notebook;
	}
	
	public static void setNotebook(ArrayList<Line> notebook) {
		Notebook.notebook = notebook;
	}
	


}
