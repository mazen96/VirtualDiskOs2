import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class IndexedAllocation implements Allocation{

	@Override
	public Vector<Integer> Save(Vector<Block> theDisk, int size, int freeBlocks,String name) {
		
		int numOfBlocks = (int) Math.ceil((size*1.0)/ theDisk.get(0).getSize());
		if(freeBlocks < numOfBlocks + 1)
		{
			System.out.println("NO FREE SPACE");
			Vector<Integer> res = new Vector<>();
			res.addElement(-1);
			res.addElement(freeBlocks);
			return res;
		}
		else
		{
			int IndexBlockRandomNum, rand;
			while(true)
			{
				IndexBlockRandomNum = ThreadLocalRandom.current().nextInt(1, theDisk.size());
				//System.out.println("rand = " + IndexBlockRandomNum);
				
				if(theDisk.get(IndexBlockRandomNum).getUsed() == false)
				{
					IndexBlock tmp = new IndexBlock();
					tmp.setUsed(true);
					tmp.setNameOfFile(name);
					freeBlocks--;
					for(int i = 0 ; i < numOfBlocks ; i++)
					{
						while(true)
						{
							rand = ThreadLocalRandom.current().nextInt(1, theDisk.size());
							Block tmpBlock = theDisk.get(rand);
							if(tmpBlock.getUsed() == false)
							{
								tmpBlock.setUsed(true);
								tmpBlock.setNameOfFile(name);
								freeBlocks--;
								tmp.addIndex(rand);
								break;
							}
						}	
					}
					theDisk.remove(IndexBlockRandomNum);
					theDisk.insertElementAt(tmp, IndexBlockRandomNum);
					break;
				}
			}
			
			Vector<Integer> res = new Vector<>();
			res.addElement(IndexBlockRandomNum);
			res.addElement(freeBlocks);
			return res;

		}
		
	}

	@Override
	public Vector<Integer> Delete(Vector<Block> theDisk ,container file, int freeSpace) {
		
		if(file instanceof File){
			file = (File)file;
			int startidx = ((File) file).getStartIndex();
			IndexBlock tmp = (IndexBlock) theDisk.get(startidx);
			for(int i = 0 ; i < tmp.indexs.size() ; i++)
			{
				theDisk.get(tmp.indexs.get(i)).setUsed(false);
				freeSpace++;
			}
			tmp.setUsed(false);
			freeSpace++;
			Vector<Integer> res = new Vector<>();
			res.addElement(1);
			res.addElement(freeSpace);
			return res;
		}
		else
		{
			
			Vector<Integer> res = new Vector<>();
			res.addElement(0);
			res.addElement(freeSpace);
			return res;
		}
		
		
	}

}