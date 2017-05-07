import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Disk {
	Tree tree;
	static Vector<Block> theDisk;
	public Integer freeBlocks;
	Allocation allocate;
	
	public Disk(){
		
	}
	
	public Disk(int sz) {
		theDisk = new Vector<Block>();
		int numOfBlocks = 1000000/sz;
		for (int i = 0; i < numOfBlocks; i++) {
			theDisk.add(new Block(sz));
		}
		freeBlocks = numOfBlocks;
		tree = new Tree();
	}

	public Allocation getAllocate() {
		return allocate;
	}

	public void setAllocate(Allocation allocate) {
		this.allocate = allocate;
	}


	public boolean CreateFolder(String name, String parentPath) {

		if (tree.exist(parentPath)) {
			if (!tree.exist(parentPath + "\\" + name)) {
				String currDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
				container tmpFolder = new Folder(name, parentPath, currDate, currDate);
				tree.addNode(parentPath, tmpFolder);
				System.out.println("Folder \" " + name + " \" " + "created successfully under path :: " + parentPath);
				return true;
			} else {
				System.out.println("ERROR! The provided path contains a folder with the same name.");
			}
		} else {
			System.out.println("ERROR! The provided path doesn't exist.");
		}

		return false;
	}

	public boolean CreateFile(String name, String parentPath, int size) {
		if (tree.exist(parentPath)) {
			if (!tree.exist(parentPath + "\\" + name)) {
				String currDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
				File tmpFile = new File(name, parentPath, currDate, currDate, size);
				tmpFile.setType(name.substring(name.indexOf(".") + 1)); //
				if (tree.addNode(parentPath, tmpFile) == true) {
					Vector<Integer> res = new Vector<Integer>();
					res = allocate.Save(theDisk, size, freeBlocks,name); 
					int startidx = res.get(0);
					freeBlocks = res.get(1);
					if (startidx != -1) {
						File tmp = (File) tree.getContainer(parentPath + "\\" + name);
						tmp.setStartIndex(startidx);
						tree.setContainer(parentPath + "\\" + name, tmp);
					} else {
						tree.deleteNode(parentPath + "\\" + name);
						return false;
					}

				} else {
					return false;
				}

			} else {
				System.out.println("ERROR! The provided path contains a file with the same name.");
			}
		} else {
			System.out.println("ERROR! The provided path doesn't exist.");
		}

		return false;
	}

	public boolean DeleteFolder(String name, String path) {
		Vector<String> all = tree.getDir(path+'\\'+name);
		if (all.size() == 0){
				System.out.println("ERROR! The provided path doesn't exist.");
				return false;
		}
	
		for (int i = 0; i < all.size(); i++) {
			 Vector<Integer> tmp =allocate.Delete(theDisk, tree.getContainer(all.get(i)), freeBlocks);
			 freeBlocks= tmp.get(1);
		}
		for (int i = 0; i < all.size(); i++) {
			tree.deleteNode(all.get(i));
		}
		return true;
	}

	public boolean DeleteFile(String path) {
		if (tree.exist(path)) {
			Vector<Integer> tmp =allocate.Delete(theDisk,  tree.getContainer(path), freeBlocks);
			 freeBlocks= tmp.get(1);
			return tree.deleteNode(path);
		} else{
			
			System.out.println("ERROR! The provided path doesn't exist.");
			return false;
		}
			
	}
	
	public void DisplayDiskStatus()
	{
		System.out.println("Empty Space    :: " + freeBlocks*theDisk.get(0).getSize() + " KB.");
		System.out.println("Occupied Space :: " + (theDisk.size() - freeBlocks)*theDisk.get(0).getSize() + " KB.");
		System.out.println("Empty Slots in the Disk :: " + freeBlocks + " -->\n");
		for(int i = 0 ; i < theDisk.size() ; i++)
		{
			if(theDisk.get(i).getUsed() == false)
			{
				System.out.print(i + " ");
			}
		}
		System.out.println("\nOccupied Slots in the Disk :: -->\n");
		for(int i = 0 ; i < theDisk.size() ; i++)
		{
			if(theDisk.get(i).getUsed() == true)
			{
				System.out.print(i + " :: " +theDisk.get(i).getNameOfFile()+"\n");
			}
		}
		System.out.println();
		
	}
	
	public void DisplayTreeStructure() { // check
		tree.display();
	}
	
	public Void Save() {
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("disk.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(tree);
	         out.writeObject(theDisk);
	         out.writeObject(freeBlocks);
	         if(allocate instanceof ContiguousAllocation){
	        	 out.writeObject(0);
	         }else out.writeObject(1);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /disk.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public Void Load(){
		try {
	         FileInputStream fileIn = new FileInputStream("disk.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         tree = (Tree) in.readObject();
	         tree.display();
	         theDisk = (Vector<Block>) in.readObject();
	         freeBlocks = (Integer) in.readObject();
	         Integer a = (Integer) in.readObject();
	         if(a == 0){
	        	 allocate = new ContiguousAllocation();
	         }else {
	        	 allocate = new IndexedAllocation();
	         }
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c) {
	         //System.out.println("Employee class not found");
	         c.printStackTrace();
	         return null;
	      }
		return null;
	}

}
