import java.util.Vector;

public class ContiguousAllocation implements Allocation{

	@Override
	public Vector<Integer> Save(Vector<Block> theDisk, int size, int freeBlocks,String name) {
		
		int numberOfBlocksNeeded = (int) Math.ceil((size*1.0)/ theDisk.get(0).getSize());
		if(freeBlocks < numberOfBlocksNeeded)
		{
			System.out.println("NO FREE SPACE");
			Vector<Integer> res = new Vector<>();
			res.addElement(-1);
			res.addElement(freeBlocks);
			return res;
		}
		int cntNumberOfFree=0,startIndex=0;
		for(int i=0;i<theDisk.size()&& cntNumberOfFree <numberOfBlocksNeeded;i++){
			if(!theDisk.get(i).getUsed()){
				cntNumberOfFree++;
			}else{
				cntNumberOfFree = 0;
				startIndex = i+1;
			}
		}
		//Case that there is no Space not handled
		if(cntNumberOfFree == numberOfBlocksNeeded){
			for(int i =startIndex;i<theDisk.size() && i<startIndex + numberOfBlocksNeeded;i++){
				theDisk.get(i).setUsed(true);
				theDisk.get(i).setNameOfFile(name);
			}
		}
		
		Vector<Integer> res = new Vector<>();
		res.addElement(startIndex);
		res.addElement(freeBlocks-numberOfBlocksNeeded);
		return res;
		
	}

	@Override
	public Vector<Integer> Delete(Vector<Block> theDisk,container file,int freeSpace) {
		if(file instanceof File){
			file = (File)file;
			int numberOfBlocksNeeded = (int) Math.ceil((((File) file).getSize()*1.0)/ theDisk.get(0).getSize());
			for(int i =((File) file).getStartIndex();i<theDisk.size() && i<((File) file).getStartIndex() + numberOfBlocksNeeded;i++){
				theDisk.get(i).setUsed(false);
				freeSpace++;
			}
			Vector<Integer> res = new Vector<>();
			res.addElement(1);
			res.addElement(freeSpace);
			return res;
		}
		Vector<Integer> res = new Vector<>();
		res.addElement(0);
		res.addElement(freeSpace);
		return res;
		
		
	}

}
