package soap.example.model;

import java.util.Date;


public class CowBcsModel implements Comparable<CowBcsModel> {

	private Long id;
	private Long cow_id;
	private Date date;
	private int cc;
	
	private static long index = 0;
		
	public CowBcsModel(Long cow_id, int cc) {
		this.id = index++;
		this.cow_id = cow_id;
		this.date = new Date();
		this.cc = cc;
	}
	
    @Override
    public int compareTo(CowBcsModel cowBcs) {
        return this.date.compareTo(cowBcs.getDate());
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());	
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CowBcsModel other = (CowBcsModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public Long getId() {
		return id;
	}

	public Long getCow_id() {
		return cow_id;
	}

	public void setCow_id(Long cow_id) {
		this.cow_id = cow_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
