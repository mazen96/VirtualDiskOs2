
public class Block {
	int size;
	boolean used;
	String nameOfFile;
	
	
	public String getNameOfFile() {
		return nameOfFile;
	}
	public void setNameOfFile(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}
	public Block() {
		this.used = false;
	}
	public Block(int sz ) {
		this.size = sz;
		this.used = false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean getUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
}
