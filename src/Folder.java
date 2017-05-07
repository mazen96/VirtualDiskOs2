
public class Folder extends container {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3883442834336356888L;
	String Folderpath ;
	
	public Folder() {
		// TODO Auto-generated constructor stub
	}
	
	public Folder(String name , String Folderpath ,String  CreationDate,String LastModificationDate) {
		this.setName(name);
		this.Folderpath = Folderpath;
		this.setCreationDate(CreationDate);
		this.setLastModificationDate(LastModificationDate);
	}
	
	
	public String getFolderpath() {
		return Folderpath;
	}

	public void setFolderpath(String folderpath) {
		Folderpath = folderpath;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Folder [Folderpath=" + Folderpath + "]";
	}
}
