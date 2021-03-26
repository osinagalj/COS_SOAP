package soap.example.model;


public class AnimalAlertModel {
	
	private int id;
	private int animalId;
	private int bcsThreshold;
	
	private static int alertIndex = 0;
	
	public AnimalAlertModel(int animalId, int bcsThreshold) {
		this.id = alertIndex++;
		this.animalId = animalId;
		this.bcsThreshold = bcsThreshold;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public int getBcsThreshold() {
		return bcsThreshold;
	}
	public void setBcsThreshold(int bcsThreshold) {
		this.bcsThreshold = bcsThreshold;
	}

}
