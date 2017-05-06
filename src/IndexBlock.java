import java.util.Vector;

public class IndexBlock extends Block {
	Vector<Integer> indexs;
	public IndexBlock() {
		super();
		indexs = new Vector<Integer>();
	}
	public Vector<Integer> getIndexs() {
		return indexs;
	}
	public void addIndex (Integer x){
		indexs.addElement(x);
	}
	
}
