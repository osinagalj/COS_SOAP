package soap.example.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.CowAlertModel;
import soap.example.model.HerdAlertModel;

@Component
public class HerdAlertRepository {

	private static final Map<Long, HerdAlertModel> alerts = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		
		HerdAlertModel c1 = new HerdAlertModel((long)1,4,6);
		HerdAlertModel c2 = new HerdAlertModel((long)1,3,8);
		HerdAlertModel c3 = new HerdAlertModel((long)1,2,7);
		HerdAlertModel c4 = new HerdAlertModel((long)1,4,8);
		
		alerts.put(c1.getId(), c1);
		alerts.put(c2.getId(), c2);
		alerts.put(c3.getId(), c3);
		alerts.put(c4.getId(), c4);
		
	}
	
	/**Add one cows alert in the repository*/
	public void addAlert(Long herd_id, int bcs_min, int bcs_max){
		HerdAlertModel alert = new HerdAlertModel(herd_id,bcs_min,bcs_max);
		alerts.put(alert.getId(), alert);
	}
	
	public void addAlert(HerdAlertModel alert){
		alerts.put(alert.getId(), alert);
	}
	
	/**Get All cows alerts in the repository*/
	public List<HerdAlertModel> getAlerts(){
		List<HerdAlertModel> new_alert = new ArrayList<HerdAlertModel>();
		for (Map.Entry<Long, HerdAlertModel> entry : alerts.entrySet()) {
			new_alert.add(entry.getValue());		    
		}
		return new_alert;
	}
	
}