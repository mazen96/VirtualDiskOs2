
public class Main {

	public static void main(String[] args) {
		Tree newTree = new Tree();
		container folder1 = new Folder();
		container folder2 = new Folder();
		container folder3 = new Folder();
		folder1.setName("Folder1");
		folder2.setName("Folder2");
		folder3.setName("Folder3");
		newTree.addNode("VFSD:", folder1 );
		newTree.addNode("VFSD:\\Folder1", folder2 );
		newTree.addNode("VFSD:\\Folder1\\Folder2", folder3);
		newTree.display();
		newTree.deleteNode("VFSD:\\Folder1\\Folder2");
		
	}

}
