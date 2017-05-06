
public class IndexFile extends container{
	int Type ,Location  , Size;
	int indexOfIndexBlock;
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
	public int getindexOfIndexBlock() {
		return indexOfIndexBlock;
	}

	public void setindexOfIndexBlock(int indexOfIndexBlock) {
		this.indexOfIndexBlock = indexOfIndexBlock;
	}

}
