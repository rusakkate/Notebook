package by.itAcademy.training.Interface;

public class Menu {
	
	public static final int NUMPOINTSTARTMENU = 4;
	
	public static void StartMenu () {
		System.out.print ("Ñhoose an action: " + "\n" + 
							"1. Add line" + "\n" + 
							"2. Find line by date" + "\n" + 
							"3. Find line by content" + "\n" +
							"4. Delete line");
	}
	
	public static final int NUMPOINTCONTINUEMENU = 2;
	
	public static void ContinueMenu () {
		System.out.println ();
		System.out.print ("Ñhoose an action: " + "\n" + 
							"1. Continue working with notebook" + "\n" + 
							"2. Finish working with notebook");
	}
	

}
