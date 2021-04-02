package soap.example.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soap.example.model.CowModel;
import soap.example.model.HerdAlertModel;
import soap.example.model.HerdModel;

@Component
public class HerdRepository {
	
	private static final Map<Long, HerdModel> herds = new HashMap<>();

	@PostConstruct
	public void initData() {
		HerdModel herd_1 = new HerdModel("rodeo 1");
		HerdModel herd_2 = new HerdModel("rodeo 2");

		XMLGregorianCalendar born_date = null;
		final GregorianCalendar now = new GregorianCalendar();
		try {
			born_date = DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
			  
		} catch (DatatypeConfigurationException e) {}
		CowModel cow1 = new CowModel(1,400f,born_date,born_date,4);
		CowModel cow2 = new CowModel(2,500f,born_date,born_date,4);
		CowModel cow3 = new CowModel(3,600f,born_date,born_date,4);
		CowModel cow4 = new CowModel(4,700f,born_date,born_date,4);
		herd_1.addCow(cow1);
		herd_1.addCow(cow2);
		herd_2.addCow(cow3);
		herd_2.addCow(cow4);
		
		
		herds.put(herd_1.getId(), herd_1);
		herds.put(herd_2.getId(), herd_2);

	}
	
	public boolean addHerd(HerdModel herd) {
		if(herds.containsKey(herd))
			return false;
		herds.put(herd.getId(), herd); 
		return true;
	}
	
	/*
	 if(cow_input != null) {
			CowModel cow = new CowModel(cow_input.getElectronicId(),
									cow_input.getWeight().floatValue(),
									cow_input.getBornDate(),
									cow_input.getLastDueDate(),
									cow_input.getNumberOfDeliveries()
			);
			
			*/

	/*If the herd exist, return true. If it not exists, return false*/
	public boolean addCowToHerd(Long id_herd, CowModel cow) {
		if(herds.containsKey(id_herd)) {
			HerdModel h = herds.get(id_herd);
			h.addCow(cow);
			herds.put(h.getId(), h);
			return true;
		}else {
			return false;
		}
	}
	
	/*Get one herd in the repository by id*/
	public HerdModel findHerd(Long id) {
		return herds.get(id);
	}
	
	
	/*Get one herd in the repository by id*/
	public CowModel findCowById(Long cow_id) {
		for (Map.Entry<Long, HerdModel> entry : herds.entrySet()) {
			List<CowModel> list = entry.getValue().getCows();
			for(CowModel cow : list)
				if(cow.getId() == cow_id)
					return cow;
		}
		return null;
	}
	
	public List<HerdModel> getAll(){
		List<HerdModel> new_herds = new ArrayList<HerdModel>();
		for (Map.Entry<Long, HerdModel> entry : herds.entrySet()) {
			new_herds.add(entry.getValue());
		
		}
		return new_herds;
	}
	
	/**Get herd id where the cow is*/
	public Long getHerdOfCow(Long cow_id){
		for (Map.Entry<Long, HerdModel> entry : herds.entrySet()) {
			List<CowModel> list = entry.getValue().getCows();
			for(CowModel cow : list)
				if(cow.getId() == cow_id)
					return entry.getValue().getId();
		
		}
		return (long)0;
	}
	
}
