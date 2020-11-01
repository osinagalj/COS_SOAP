package soap.example.model;

public class CowModel {
	private long id;
	
	private float weight;
	
	private static long cowIndex = 0;

	public CowModel(float weight) {
		this.id = cowIndex++;
		this.weight = weight;
	}

	public long getId() {
		return id;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
