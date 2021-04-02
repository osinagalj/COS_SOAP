package soap.example.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.CowAlertModel;



@Component
public class CowAlertRepository {

	private static final Map<Long, CowAlertModel> alerts = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		
		CowAlertModel c1 = new CowAlertModel((long)1,4,6);
		CowAlertModel c2 = new CowAlertModel((long)1,3,8);
		CowAlertModel c3 = new CowAlertModel((long)1,2,7);
		CowAlertModel c4 = new CowAlertModel((long)1,4,8);
		
		alerts.put(c1.getId(), c1);
		alerts.put(c2.getId(), c2);
		alerts.put(c3.getId(), c3);
		alerts.put(c4.getId(), c4);
		
	}
	
	/**Add one cows alert in the repository*/
	public void addAlert(Long cow_id, int bcs_min, int bcs_max){
		CowAlertModel alert = new CowAlertModel(cow_id,bcs_min,bcs_max);
		alerts.put(alert.getId(), alert);
	}

	public void addAlert(CowAlertModel alert){
		alerts.put(alert.getId(), alert);
	}
	
	/**Get All cows alerts in the repository*/
	public List<CowAlertModel> getAlerts(){
		List<CowAlertModel> new_alert = new ArrayList<CowAlertModel>();
		for (Map.Entry<Long, CowAlertModel> entry : alerts.entrySet()) {
			new_alert.add(entry.getValue());		    
		}
		return new_alert;
	}
	
}