import java.util.Vector;

public interface Allocation {

	Void Save(Vector<Block> theDisk, int size);
	Void Delete(Vector<Block> theDisk);
	
}
