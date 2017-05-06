import java.util.Vector;

public class Disk {
	Tree tree ;
	Vector<Block> theDisk;
	Allocation allocate;
	
	public Disk(int n){
		theDisk = new Vector<Block>(n);
	}
	
	public Allocation getAllocate() {
		return allocate;
	}

	public void setAllocate(Allocation allocate) {
		this.allocate = allocate;
	}


	
	void DisplayStatus(){
		
	}
	
	void DisplayTreeStructure(){
		
	}
	
	boolean CreateFolder(String name ,String Path) {
		return false;
	}
	
	boolean CreateFile(String name ,String Path , int size) {
		return false;
	}
	
	boolean DeleteFoler(String name , String path){
		return false;
	}
	boolean DeleteFile(String path){
		return false;
	}
	
	
	
}
