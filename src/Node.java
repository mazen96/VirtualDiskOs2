import java.util.ArrayList;

public class Node {

	private container identifier;
    private ArrayList<Node> children;

    // Constructor
    public Node(container identifier) {
        this.identifier = identifier;
        children = new ArrayList<Node>();
    }

    // Properties
    public container getIdentifier() {
        return identifier;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(Node identifier) {
        children.add(identifier);
    }
}