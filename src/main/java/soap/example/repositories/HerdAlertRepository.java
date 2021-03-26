package soap.example.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.AnimalAlertModel;
import soap.example.model.HerdAlertModel;

@Component
public class HerdAlertRepository {

	private static final Map<Integer, HerdAlertModel> alerts = new HashMap<>();
	
	@PostConstruct
	public void initData() {

	}
	
	public HerdAlertModel findAlert(int id) {
		return alerts.get(id);
	}
	
	public void addAlert(int animalId, int bcs){
		HerdAlertModel alert = new HerdAlertModel(animalId,bcs);
		alerts.put(alert.getId(), alert);
	}
	
	public ArrayList<HerdAlertModel> getAlerts(){
		ArrayList<HerdAlertModel> alert2 = new ArrayList<HerdAlertModel>();
		
		for (Map.Entry<Integer, HerdAlertModel> entry : alerts.entrySet()) {
			System.out.println("agregando el alerta id =  " + entry.getKey());
			alert2.add(entry.getValue());		    
		}
		System.out.println("Entro aca, tamaño de las alertas = " + alert2.size());
		
		return alert2;
	}
	
}