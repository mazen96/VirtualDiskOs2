import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class Tree {

    private final static String ROOTPATH = "VFSD:";
    private Map<String, Node> nodes;

    // Constructors
    public Tree() {
    	String str = new SimpleDateFormat("HH:mm:ss").format(new Date());
    	container root = new Folder("root", ROOTPATH, str , str );
    	this.nodes = new HashMap<String, Node>();
    	Node node = new Node(root);
    	 nodes.put(ROOTPATH, node);
    }


    // Properties
    public Map<String, Node> getNodes() {
        return nodes;
    }
 
   

    public boolean addNode(String ParentPath,container child) {
        Node node = new Node(child);
        Node nodeParent = nodes.get(ParentPath);
        
        if(nodeParent != null && nodeParent.getIdentifier() instanceof Folder){
        	nodes.put(ParentPath+"\\"+child.getName(), node);
        	nodes.get(ParentPath).addChild(node);
        	return true;
        }

        return false;
    }

    
    public void display() {
    	Vector<String> all = new Vector<String>();
    	for (Entry<String, Node> entry : nodes.entrySet()) {
    		all.add(entry.getKey());
    	}
    	Collections.sort(all);
    	for(String tmp : all){
    		System.out.println(tmp);
    	}
    }



}