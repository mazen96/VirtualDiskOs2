
public class File extends container{
	private int Size, startIndex;
	String FilePath;
	String type;
	
	public File(){
		// TODO Auto-generated constructor stub
	}
	
	public File(String name , String FilePath ,String  CreationDate,String LastModificationDate, int size) {
		this.setName(name);
		this.FilePath = FilePath;
		this.setCreationDate(CreationDate);
		this.setLastModificationDate(LastModificationDate);
		this.setSize(size);
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	
	public String getFilePath() {
		return FilePath;
	}
	

}
