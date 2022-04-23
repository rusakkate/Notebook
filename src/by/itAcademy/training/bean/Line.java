package by.itAcademy.training.bean;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Line {
	private String string;
	private Calendar dateOfCreation = new GregorianCalendar();
	
	public Line () {
		dateOfCreation = new GregorianCalendar();
	}
	
	
	public Line (String string) {
		this();
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public Calendar getDateOfCreation() {
		return dateOfCreation;
	}

	public void setString(String string) {
		this.string = string;
	}

	public void setDateOfCreation(Calendar dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfCreation, string);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(dateOfCreation, other.dateOfCreation) && Objects.equals(string, other.string);
	}

	@Override
	public String toString() {
		return dateOfCreation.getTime() + "; " + string;
	}
	

}
