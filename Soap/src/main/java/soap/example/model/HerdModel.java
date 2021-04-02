package soap.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HerdModel {
	private Long id;
	private List<CowModel> cows;
	private String location;
	
	private static long index = 0;
	
	public HerdModel(String location) {
		this.id = index++;
		cows = new ArrayList<CowModel>();
		this.location = location;
	}
	
	public void addCow(CowModel cow) {
		this.cows.add(cow);
	}
	

	public List<CowModel> getCows() {
		return cows;
	}

	public void setCows(List<CowModel> cows) {
		this.cows = cows;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
}
