import java.util.Vector;

public class IndexBlock extends Block {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6783222261180716937L;
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
