import java.util.Vector;

public interface Allocation {

	Vector<Integer> Save(Vector<Block> theDisk, int size, int freeBlocks,String name);
	Vector<Integer> Delete(Vector<Block> theDisk,container file,int freeBlocks);
	
}
