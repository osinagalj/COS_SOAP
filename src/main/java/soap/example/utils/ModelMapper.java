package soap.example.utils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ar.edu.isistan.springsoap.gen.CowAlertOutput;
import ar.edu.isistan.springsoap.gen.CowBcsOutput;
import ar.edu.isistan.springsoap.gen.CowInput;
import ar.edu.isistan.springsoap.gen.CowOutput;
import ar.edu.isistan.springsoap.gen.HerdAlertOutput;
import soap.example.model.CowAlertModel;
import soap.example.model.CowBcsModel;
import soap.example.model.CowModel;
import soap.example.model.HerdAlertModel;

public class ModelMapper {
	
	public static CowOutput mapper(CowModel cow) {
		
		CowOutput cow_io = new CowOutput(); 
		cow_io.setId((int) cow.getId());
		cow_io.setWeight(new BigDecimal(cow.getWeight()));
		cow_io.setElectronicId(cow.getElectronicId());	
		cow_io.setBornDate(cow.getBorn_date());
		cow_io.setLastDueDate(cow.getLastDueDate());
		
		return cow_io;
	}
	public static CowBcsOutput mapper(CowBcsModel cowBcs) {
		
		if(cowBcs != null) {
			CowBcsOutput bcs_out = new CowBcsOutput();
			bcs_out.setCc(cowBcs.getCc());
			bcs_out.setCowId(cowBcs.getCow_id().intValue());
			bcs_out.setId(cowBcs.getId());
			
			XMLGregorianCalendar born_date = null;

			Instant i = cowBcs.getDate().toInstant();
		    String dateTimeString = i.toString();
		    
		    try {
		    	born_date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
			} catch (DatatypeConfigurationException e) {
				
				e.printStackTrace();
			}
			
			
			bcs_out.setDate(born_date);
			
			return bcs_out;
		}else
			return null;
	}
	
	public static CowAlertOutput mapper(CowAlertModel alert) {
		
		CowAlertOutput alert_out = new CowAlertOutput();
		alert_out.setId(alert.getId());
		alert_out.setCowId(alert.getAnimalId().intValue());
		alert_out.setBcsThresholdMin(alert.getBcsThreshold_min());
		alert_out.setBcsThresholdMax(alert.getBcsThreshold_max());
			
		return alert_out;
	}
	
	public static HerdAlertOutput mapper(HerdAlertModel alert) {
		
		HerdAlertOutput alert_out = new HerdAlertOutput();
		alert_out.setId(alert.getId());
		alert_out.setHerdId(alert.getHerd_id().intValue());
		alert_out.setBcsThresholdMin(alert.getBcsThreshold_min());
		alert_out.setBcsThresholdMax(alert.getBcsThreshold_max());
			
		return alert_out;
	}
	
}
