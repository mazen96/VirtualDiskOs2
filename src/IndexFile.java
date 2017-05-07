
public class IndexFile extends container{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1531151526829288033L;
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

	@Override
	public String toString() {
		return super.toString()+"IndexFile [Type=" + Type + ", Location=" + Location + ", Size=" + Size + ", indexOfIndexBlock="
				+ indexOfIndexBlock + "]";
	}

}
