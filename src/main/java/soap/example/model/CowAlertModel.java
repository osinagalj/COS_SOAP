package soap.example.model;


public class CowAlertModel {
	
	private Long id;
	private Long animalId;
	private int bcsThreshold_min;
	private int bcsThreshold_max;
	
	private static long index = 0;
	
	public CowAlertModel(Long animalId, int bcsThreshold_min, int bcsThreshold_max ) {
		this.id = index++;
		this.animalId = animalId;
		this.bcsThreshold_min = bcsThreshold_min;
		this.bcsThreshold_max = bcsThreshold_max;
	}
	

	public Long getId() {
		return id;
	}

	public Long getAnimalId() {
		return animalId;
	}


	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}


	public static Long getIndex() {
		return index;
	}


	public int getBcsThreshold_min() {
		return bcsThreshold_min;
	}


	public void setBcsThreshold_min(int bcsThreshold_min) {
		this.bcsThreshold_min = bcsThreshold_min;
	}


	public int getBcsThreshold_max() {
		return bcsThreshold_max;
	}


	public void setBcsThreshold_max(int bcsThreshold_max) {
		this.bcsThreshold_max = bcsThreshold_max;
	}



}
