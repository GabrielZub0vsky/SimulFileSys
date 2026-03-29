<<<<<<< HEAD
/**
 * file name: File.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a file as a node that can have text contents.
 */

public class File extends Node {
	String contents;

	public File(String fileName) {
		name = fileName;
		isFile = true;
		isDir = false;
		contents = "";
	}
	
	/** 
	 * Sets the contents of a file
	 */
	public void setContents(String value) {
		contents = value;
	}
	
	/**
	 * Gets the contents of a file
	 */
	protected String getContents() {
		return contents;
	}
	
	/**
	 * Gets the length in characters of the contents of a file
	 * @return
	 */
	protected int getLength() {
		return contents.length();
	}	
}
=======
/**
 * file name: File.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a file as a node that can have text contents.
 */

public class File extends Node {
	String contents;

	public File(String fileName) {
		name = fileName;
		isFile = true;
		isDir = false;
		contents = "";
	}
	
	/** 
	 * Sets the contents of a file
	 */
	public void setContents(String value) {
		contents = value;
	}
	
	/**
	 * Gets the contents of a file
	 */
	protected String getContents() {
		return contents;
	}
	
	/**
	 * Gets the length in characters of the contents of a file
	 * @return
	 */
	protected int getLength() {
		return contents.length();
	}	
}
>>>>>>> 38d6b556e347050e44369f72fa3cc6e1f6ff23ba
