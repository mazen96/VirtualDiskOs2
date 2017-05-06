
public class Folder extends container {
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
	
	
}
