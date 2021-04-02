package soap.example.model;

import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CowModel {
	
	private static long cowIndex = 0;
	
	private Long id;
	private float weight;
	private int electronicId;
	private XMLGregorianCalendar born_date;
	private XMLGregorianCalendar lastDueDate;
	private int numberOfDeliveries;
	
	public CowModel() {}
	
	public CowModel(int electronicId, float weigth,XMLGregorianCalendar born_date, XMLGregorianCalendar lastDueDate, int numberOfDeliveries ) {
		this.id = cowIndex++;
		this.electronicId = electronicId;
		this.weight = weigth;
		this.born_date = born_date;
		this.lastDueDate = lastDueDate;
		this.numberOfDeliveries = numberOfDeliveries;
	}
	/*
	final GregorianCalendar now = new GregorianCalendar();
	// in case you need to set the date with a given java.util.Date instance
	// now.setTime(date);
	try {
		this.born_date =  DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
		this.lastDueDate =  this.born_date;
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/

	
	//---------------------------------------------------------------------------------------------//
	//------------------------------ Getters && Setters -------------------------------------------//
	//---------------------------------------------------------------------------------------------//
	
	public long getId() {
		return id;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public static long getCowIndex() {
		return cowIndex;
	}

	public static void setCowIndex(long cowIndex) {
		CowModel.cowIndex = cowIndex;
	}

	public int getElectronicId() {
		return electronicId;
	}

	public void setElectronicId(int electronicId) {
		this.electronicId = electronicId;
	}

	public XMLGregorianCalendar getBorn_date() {
		return born_date;
	}

	public void setBorn_date(XMLGregorianCalendar born_date) {
		this.born_date = born_date;
	}

	public XMLGregorianCalendar getLastDueDate() {
		return lastDueDate;
	}

	public void setLastDueDate(XMLGregorianCalendar lastDueDate) {
		this.lastDueDate = lastDueDate;
	}

	public int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public void setNumberOfDeliveries(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
