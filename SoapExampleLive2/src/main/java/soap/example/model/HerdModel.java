package soap.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HerdModel {
	private long id;
	private List<CowModel> cows;
	
	private static long herdIndex = 0;
	
	public HerdModel() {
		this.id = herdIndex++;
		cows = new ArrayList<CowModel>();
	}
	
	public void addCow(CowModel cow) {
		cows.add(cow);
	}

	public long getId() {
		return id;
	}

	public List<CowModel> getCows() {
		return Collections.unmodifiableList(cows);
	}
	
	
	
}
