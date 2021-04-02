package soap.example.model;


public class HerdAlertModel {
	
	private Long id;
	private Long herd_id;
	private int bcsThreshold_min;
	private int bcsThreshold_max;
	
	private static long index = 0;
	
	public HerdAlertModel() {}
	
	public HerdAlertModel(Long herd_id, int bcsThreshold_min, int bcsThreshold_max) {
		this.id = index++;
		this.herd_id = herd_id;
		this.bcsThreshold_min = bcsThreshold_min;
		this.bcsThreshold_max = bcsThreshold_max;
	}

	public Long getId() {
		return id;
	}

	public Long getHerd_id() {
		return herd_id;
	}

	public void setHerd_id(Long herd_id) {
		this.herd_id = herd_id;
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