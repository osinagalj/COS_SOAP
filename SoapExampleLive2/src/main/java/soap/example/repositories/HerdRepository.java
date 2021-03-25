package soap.example.repositories;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ar.edu.isistan.springsoap.gen.Cow;
import soap.example.model.CowModel;
import soap.example.model.HerdModel;

@Component
public class HerdRepository {
	
	private static final Map<Long, HerdModel> herds = new HashMap<>();
	
	
	@PostConstruct
	public void initData() {
		
		CowModel cow = new CowModel(100f);
		CowModel cow2 = new CowModel(100f);
		HerdModel herd = new HerdModel();
		
		herd.addCow(cow);
		herd.addCow(cow2);
		
		herds.put(herd.getId(), herd);

		
	}
	
	public void addHerd(HerdModel herd) {
		herds.put(herd.getId(), herd); 
	}
	
	public void addCowToHerd(Long id_herd, Cow _cow){
		
		if(_cow != null) {
			CowModel cow = new CowModel(_cow.getId(),_cow.getWeight().floatValue());
			if(herds.containsKey(id_herd)) {
				HerdModel h = herds.get(id_herd);
				h.addCow(cow);
				herds.put(h.getId(), h);
			}
		}
		
	}
	
	public boolean associateCowToHerd(Long id_herd, CowModel cow) {
		if(herds.containsKey(id_herd)) {
			HerdModel h = herds.get(id_herd);
			h.addCow(cow);
			herds.put(h.getId(), h);
			return true;
		}else {
			return false;
		}
	}
	
	
	public HerdModel findHerd(Long id) {
		return herds.get(id);
	}
	
}
