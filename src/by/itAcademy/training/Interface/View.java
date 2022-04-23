package by.itAcademy.training.Interface;

import java.util.ArrayList;

import by.itAcademy.training.bean.Line;

public class View {
	
	public static void printArray (ArrayList <Line> arrayList, String message) {
		
		if (arrayList.isEmpty()) {
			System.out.println ("Notes are missing");
		} else {
			System.out.println(message);
			for (Line l: arrayList) {
				System.out.println (l.toString());
			}
		}
	}
	
	public static void printResult (String message) {
		System.out.println(message);
		
	}
	

}
