import java.util.Vector;

public class Disk {
	Tree tree ;
	static Vector<Block> theDisk;
	Allocation allocate;
	
	public Disk(int n,int sz){
		theDisk = new Vector<Block>();
		for(int i=0;i<n;i++){
			theDisk.add(new Block(sz));
		}
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
	
	boolean DeleteFolder(String name , String path){
		Vector<String> all = tree.getDir(path);
		if(all.size() == 0)return false;
		for(int i=0;i<all.size();i++){
			allocate.Delete(theDisk, tree.getContainer(all.get(i)));
		}
		for(int i=0;i<all.size();i++){
			return tree.deleteNode(all.get(i));
		}
		return true;
	}
	boolean DeleteFile(String path){
		if(tree.exist(path)){
			allocate.Delete(theDisk, tree.getContainer(path));
			return tree.deleteNode(path);
		}else return false;
	}
	
	
	
}
