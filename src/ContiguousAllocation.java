import java.util.Vector;

public class ContiguousAllocation implements Allocation{

	@Override
	public Integer Save(Vector<Block> theDisk, int size) {
		int numberOfBlocksNeeded = (int) Math.ceil((size*1.0)/ theDisk.get(0).getSize());
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
			}
		}
		
		
		return startIndex;
		
	}

	@Override
	public Void Delete(Vector<Block> theDisk,container file) {
		if(file instanceof File){
			file = (File)file;
			int numberOfBlocksNeeded = (int) Math.ceil((((File) file).getSize()*1.0)/ theDisk.get(0).getSize());
			for(int i =((File) file).getStartIndex();i<theDisk.size() && i<((File) file).getStartIndex() + numberOfBlocksNeeded;i++){
				theDisk.get(i).setUsed(false);
			}
		}
		return null;
	}

}
