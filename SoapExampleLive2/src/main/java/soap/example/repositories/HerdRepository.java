package soap.example.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

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
	
	public HerdModel findHerd(Long id) {
		return herds.get(id);
	}
	
}
