
public abstract class container implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3431513269553955004L;
	String name;
	String CreationDate,LastModificationDate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	public String getLastModificationDate() {
		return LastModificationDate;
	}
	public void setLastModificationDate(String lastModificationDate) {
		LastModificationDate = lastModificationDate;
	}
	@Override
	public String toString() {
		return "container [name=" + name + ", CreationDate=" + CreationDate + ", LastModificationDate="
				+ LastModificationDate + "]";
	}
	
	
}
