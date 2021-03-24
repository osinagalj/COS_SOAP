package soap.example.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.CowModel;

@Component
public class CowRepository {
	
	private static final Map<Long, CowModel> cows = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		CowModel cow1 = new CowModel(80f);
		CowModel cow2 = new CowModel(90f);
		CowModel cow3 = new CowModel(100f);
		CowModel cow4 = new CowModel(110f);
		
		cows.put(cow1.getId(), cow1);
		cows.put(cow2.getId(), cow2);
		cows.put(cow3.getId(), cow3);
		cows.put(cow4.getId(), cow4);
		
	}
	
	public CowModel findAnimal(Long id) {
		return cows.get(id);
	}
	

}
