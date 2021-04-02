package soap.example.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import soap.example.model.CowBcsModel;

@Component
public class CowBcsRepository {
	
private static final Map<Long, CowBcsModel> cowsBcs = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		CowBcsModel cowBcs1 = new CowBcsModel((long)1,1);
		CowBcsModel cowBcs2 = new CowBcsModel((long)1,5);
		CowBcsModel cowBcs3 = new CowBcsModel((long)2,7);
		CowBcsModel cowBcs4 = new CowBcsModel((long)2,6);
		
		CowBcsModel cowBcs5 = new CowBcsModel((long)0,8);
		CowBcsModel cowBcs6 = new CowBcsModel((long)3,5);

		
		cowsBcs.put(cowBcs1.getId(), cowBcs1);
		cowsBcs.put(cowBcs2.getId(), cowBcs2);
		cowsBcs.put(cowBcs3.getId(), cowBcs3);
		cowsBcs.put(cowBcs4.getId(), cowBcs4);
		cowsBcs.put(cowBcs5.getId(), cowBcs5);
		cowsBcs.put(cowBcs6.getId(), cowBcs6);
	}
	
	public CowBcsModel findBcs(Long id) {
		return cowsBcs.get(id);
	}
	
	public CowBcsModel findLastBcs(long cow_id) {
		List<CowBcsModel> list_cowsBcs = new ArrayList<CowBcsModel>();
		
		for (Map.Entry<Long, CowBcsModel> entry : cowsBcs.entrySet()) {
			if(entry.getValue().getCow_id().equals(cow_id))
				list_cowsBcs.add(entry.getValue());		    
		}
		
		Collections.sort(list_cowsBcs);
		Collections.reverse(list_cowsBcs);
		
		
		if(list_cowsBcs.isEmpty())
			return null;
		
		return list_cowsBcs.get(0);
	}
	
	public boolean addCowBcs(Long cow_id, int cc) {
		CowBcsModel c = new CowBcsModel(cow_id, cc);
		cowsBcs.put(c.getId(),c);
		return true;
		
	}
	
	public boolean addCowBcs(CowBcsModel c) {
		cowsBcs.put(c.getId(),c);
		return true;
		
	}

}
