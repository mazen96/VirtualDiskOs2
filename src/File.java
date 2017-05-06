
public class File extends container{
	int Type ,Location  , Size,startIndex;
	
	public File(){
		super();
	}
	
	public File(int type, int location, int size, int startIndex) {
		super();
		Type = type;
		Location = location;
		Size = size;
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public int getLocation() {
		return Location;
	}

	public void setLocation(int location) {
		Location = location;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}
	

}
