<<<<<<< HEAD
/**
 * file name: Node.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a node in a non-binary tree.
 */

abstract class Node implements Comparable<Node> {
	String name;
	private Directory parent;
	boolean isFile;
	boolean isDir;
	
	/**
	 * gets the parent of a node
	 */
	protected Directory getParent() {
		return parent;
	}
	
	/** 
	 * sets the parent of a node
	 */
	protected void setParent(Directory d) {
		parent = d;
	}
	
	/**
	 * checks whether two nodes are 
	 */
	public boolean equals(Object o) {
		if(o == null) { return false; }
		
		if(o instanceof Node) {
			Node n = (Node) o;
			return name.equals(n.name);
		}
		else {
			return false;
		}
	}		
	
	/**
	 * compares two nodes by name
	 */
	public int compareTo(Node n) {
		return name.compareTo(n.name);
	}

	// returns node as a string
	public String toString() {
		return name;
	}
}
=======
/**
 * file name: Node.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a node in a non-binary tree.
 */

abstract class Node implements Comparable<Node> {
	String name;
	private Directory parent;
	boolean isFile;
	boolean isDir;
	
	/**
	 * gets the parent of a node
	 */
	protected Directory getParent() {
		return parent;
	}
	
	/** 
	 * sets the parent of a node
	 */
	protected void setParent(Directory d) {
		parent = d;
	}
	
	/**
	 * checks whether two nodes are 
	 */
	public boolean equals(Object o) {
		if(o == null) { return false; }
		
		if(o instanceof Node) {
			Node n = (Node) o;
			return name.equals(n.name);
		}
		else {
			return false;
		}
	}		
	
	/**
	 * compares two nodes by name
	 */
	public int compareTo(Node n) {
		return name.compareTo(n.name);
	}

	// returns node as a string
	public String toString() {
		return name;
	}
}
>>>>>>> 38d6b556e347050e44369f72fa3cc6e1f6ff23ba
