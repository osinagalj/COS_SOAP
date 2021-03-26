package soap.example.model;


public class HerdAlertModel {
	
	private int id;
	private int herdId;
	private int bcsThreshold;
	private static int alertIndex = 0;
	
	public HerdAlertModel() {}
	
	public HerdAlertModel(int herdId, int bcsThreshold) {
		this.id = alertIndex++;
		this.herdId = herdId;
		this.bcsThreshold = bcsThreshold;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getHerdId() {
		return herdId;
	}

	public void setHerdId(int herdId) {
		this.herdId = herdId;
	}

	public int getBcsThreshold() {
		return bcsThreshold;
	}
	public void setBcsThreshold(int bcsThreshold) {
		this.bcsThreshold = bcsThreshold;
	}

}