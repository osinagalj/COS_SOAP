package soap.example.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.AnimalAlertModel;



@Component
public class AnimalAlertRepository {

	private static final Map<Integer, AnimalAlertModel> alerts = new HashMap<>();
	
	@PostConstruct
	public void initData() {
	
	}
	
	public void addAlert(int animalId, int bcs){
		AnimalAlertModel alert = new AnimalAlertModel(animalId,bcs);
		alerts.put(alert.getId(), alert);
	}
	
	public AnimalAlertModel findAlert(int id) {
		return alerts.get(id);
	}
	
	
	public ArrayList<AnimalAlertModel> getAlerts(){
		ArrayList<AnimalAlertModel> alert2 = new ArrayList<AnimalAlertModel>();
		
		for (Map.Entry<Integer, AnimalAlertModel> entry : alerts.entrySet()) {
			System.out.println("agregando el alerta id =  " + entry.getKey());
			alert2.add(entry.getValue());		    
		}
		System.out.println("Entro aca, tamaño de las alertas = " + alert2.size());
		
		return alert2;
	}
	
}