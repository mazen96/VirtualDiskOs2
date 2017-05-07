import java.util.Vector;

public interface Allocation {

	Vector<Integer> Save(Vector<Block> theDisk, int size, int freeBlocks);
	boolean Delete(Vector<Block> theDisk,container file);
	
}
