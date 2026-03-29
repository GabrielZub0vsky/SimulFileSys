<<<<<<< HEAD
/**
 * file name: Tree.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a tree of nodes, which can be files or directories. Simulates a file system.
 */

public class Tree {
	Directory root;
	Directory current;
	
	Tree(){
		root = new Directory("/");
		current = root;
	}
	
	/** create(String fileName)
	 * Creates a file named "fileName" that can contain characters of text.
	 * @param fileName - the name of the file
	 */
	public File create(String fileName) {
		File file = null;
		if(current.containsFile(fileName)) {
			System.out.println("ERROR: File named " + fileName + " already exists inside current directory");	
		}
		else if(current.containsDir(fileName)) {
			System.out.println("ERROR: Directory named " + fileName + " already exists inside current directory");	
		}
		else if(fileName.contains("/") || fileName.equals("..")) {
			System.out.println("ERROR: Invalid file name");
		}
		else {
			file = new File(fileName);
			current.addFile(file);
		}
		return file;
	}
	
	/** cat(String filename)
	 * Prints out the contents of a file to console.
	 * @param filename - the name of the file 
	 */
	public void cat(String filename) {
		if(current.containsDir(filename)) {
			System.out.println("ERROR: " + filename + " is a directory, not a file");
		}
		else if(!current.containsFile(filename)) {	
			System.out.println("ERROR: File named " + filename + " does not exist inside current directory");
		}
		else {
			System.out.println(current.getFile(filename).getContents());
		}
	}
	
	/** rm(String filename)
	 * Removes (if it exists), from the current directory, a file named "filename"
	 * @param filename - the name of the file 
	 */
	public void rm(String filename) {
		if(current.containsDir(filename)) {
			System.out.println("ERROR: " + filename + " is a directory, not a file");
		}
		else if(!current.containsFile(filename)) {	
			System.out.println("ERROR: File named " + filename + " does not exist inside current directory");
		}
		else {
			current.removeFile(filename);
		}
	}
	
	/** mkdir(String dirName)
	 * Creates a directory named "dirName".
	 * @param dirName - the name of the directory to create
	 */
	public void mkdir(String dirName) {
		if(current.containsFile(dirName)) {
			System.out.println("ERROR: File named " + dirName + " already exists inside current directory");	
		}
		else if(current.containsDir(dirName)) {
			System.out.println("ERROR: Directory named " + dirName + " already exists inside current directory");	
		}
		else if(dirName.contains("/") || dirName.contains("..")) {
			System.out.println("ERROR: Invalid directory name");
		}
		else {
			Directory dir = new Directory(dirName);
			current.addDir(dir);
			dir.setParent(current);
		}
	}
	
	/** rmdir(String dirName)
	 * Removes the directory named "dirName", along with all of its files and subdirectories.
	 * @param dirName - the name of the directory to remove
	 */
	public void rmdir(String dirName) {
		if(dirName.equals("/")) {
			System.out.println("ERROR: No such directory");
		}
		else if(current.containsFile(dirName)) {
			System.out.println("ERROR: " + dirName + " is a file, not a directory");
		}
		else if(!current.containsDir(dirName)) {	
			System.out.println("ERROR: Directory named " + dirName + " does not exist inside current directory");
		}
		else {
			current.removeDir(dirName);
		}
	}
	
	/** cd(String dirName)
	 * Moves to a directory named "dirName" if it can be found.
	 * @param path - the name/path of the directory to move to
	 */
	public void cd(String path) {
		if (path.isEmpty()) {
			;
		}
		else if(path.startsWith("/")) {
			current = root;
			cd(path.substring(1));
		}
		else {
			String[] splitPath = path.split("/", 2);
			String dir = splitPath[0];
			
			if(current.containsFile(dir)) {
				System.out.println("ERROR: " + dir + " is a file, not a directory");
				return;
			}

			if(dir.equals("..")) {
				if (current.getParent() != null) {
					current = current.getParent();
				}
			}
			else {
				if(!current.containsDir(dir)) {	
					System.out.println("ERROR: Directory " + dir + " does not exist inside current directory");
					return;
				}
				current = current.getDir(dir);
			}
			
			if(splitPath.length > 1) {
				cd(splitPath[1]);
			}
		}
	}
	
	/** ls()
	 * Lists all files and directories in current directory in
	 * alphabetical order, printing " (*)" after names of directories.
	 */
	public void ls() {
		String[] sortedNames = current.fdsort();
		for(String s : sortedNames) {
			System.out.println(s);
		}
	}
	
	/** du()
	 * Uses recursion to calculate the disk usage of the current 
	 * directory's files and the files in all of its subdirectories. 
	 */
	public void du() {
		long totalSize = current.du();
		System.out.println(totalSize + " characters");
	}
	
	/** pwd()
	 * Uses recursion to print the full directory path of the current directory.
	 */
	public void pwd() {
		String wd = current.pwd();
		if (wd.isEmpty()) {
			wd = "/";
		}
		System.out.println(wd);
	}
	
	/** find(String name)
	 * Using recursion, finds all files or directories named "name" and prints their full paths. 
	 * 
	 * @param name - the name that the user wishes to find files or directories named 
	 */
	public void find(String name) {
		current.find(name, current.pwd());
	}
	
	
	/**
	 * Prints the tree in an indent-formatted manner
	 */
	public void print() {
		root.print("", current);
	}
}
=======
/**
 * file name: Tree.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a tree of nodes, which can be files or directories. Simulates a file system.
 */

public class Tree {
	Directory root;
	Directory current;
	
	Tree(){
		root = new Directory("/");
		current = root;
	}
	
	/** create(String fileName)
	 * Creates a file named "fileName" that can contain characters of text.
	 * @param fileName - the name of the file
	 */
	public File create(String fileName) {
		File file = null;
		if(current.containsFile(fileName)) {
			System.out.println("ERROR: File named " + fileName + " already exists inside current directory");	
		}
		else if(current.containsDir(fileName)) {
			System.out.println("ERROR: Directory named " + fileName + " already exists inside current directory");	
		}
		else if(fileName.contains("/") || fileName.equals("..")) {
			System.out.println("ERROR: Invalid file name");
		}
		else {
			file = new File(fileName);
			current.addFile(file);
		}
		return file;
	}
	
	/** cat(String filename)
	 * Prints out the contents of a file to console.
	 * @param filename - the name of the file 
	 */
	public void cat(String filename) {
		if(current.containsDir(filename)) {
			System.out.println("ERROR: " + filename + " is a directory, not a file");
		}
		else if(!current.containsFile(filename)) {	
			System.out.println("ERROR: File named " + filename + " does not exist inside current directory");
		}
		else {
			System.out.println(current.getFile(filename).getContents());
		}
	}
	
	/** rm(String filename)
	 * Removes (if it exists), from the current directory, a file named "filename"
	 * @param filename - the name of the file 
	 */
	public void rm(String filename) {
		if(current.containsDir(filename)) {
			System.out.println("ERROR: " + filename + " is a directory, not a file");
		}
		else if(!current.containsFile(filename)) {	
			System.out.println("ERROR: File named " + filename + " does not exist inside current directory");
		}
		else {
			current.removeFile(filename);
		}
	}
	
	/** mkdir(String dirName)
	 * Creates a directory named "dirName".
	 * @param dirName - the name of the directory to create
	 */
	public void mkdir(String dirName) {
		if(current.containsFile(dirName)) {
			System.out.println("ERROR: File named " + dirName + " already exists inside current directory");	
		}
		else if(current.containsDir(dirName)) {
			System.out.println("ERROR: Directory named " + dirName + " already exists inside current directory");	
		}
		else if(dirName.contains("/") || dirName.contains("..")) {
			System.out.println("ERROR: Invalid directory name");
		}
		else {
			Directory dir = new Directory(dirName);
			current.addDir(dir);
			dir.setParent(current);
		}
	}
	
	/** rmdir(String dirName)
	 * Removes the directory named "dirName", along with all of its files and subdirectories.
	 * @param dirName - the name of the directory to remove
	 */
	public void rmdir(String dirName) {
		if(dirName.equals("/")) {
			System.out.println("ERROR: No such directory");
		}
		else if(current.containsFile(dirName)) {
			System.out.println("ERROR: " + dirName + " is a file, not a directory");
		}
		else if(!current.containsDir(dirName)) {	
			System.out.println("ERROR: Directory named " + dirName + " does not exist inside current directory");
		}
		else {
			current.removeDir(dirName);
		}
	}
	
	/** cd(String dirName)
	 * Moves to a directory named "dirName" if it can be found.
	 * @param path - the name/path of the directory to move to
	 */
	public void cd(String path) {
		if (path.isEmpty()) {
			;
		}
		else if(path.startsWith("/")) {
			current = root;
			cd(path.substring(1));
		}
		else {
			String[] splitPath = path.split("/", 2);
			String dir = splitPath[0];
			
			if(current.containsFile(dir)) {
				System.out.println("ERROR: " + dir + " is a file, not a directory");
				return;
			}

			if(dir.equals("..")) {
				if (current.getParent() != null) {
					current = current.getParent();
				}
			}
			else {
				if(!current.containsDir(dir)) {	
					System.out.println("ERROR: Directory " + dir + " does not exist inside current directory");
					return;
				}
				current = current.getDir(dir);
			}
			
			if(splitPath.length > 1) {
				cd(splitPath[1]);
			}
		}
	}
	
	/** ls()
	 * Lists all files and directories in current directory in
	 * alphabetical order, printing " (*)" after names of directories.
	 */
	public void ls() {
		String[] sortedNames = current.fdsort();
		for(String s : sortedNames) {
			System.out.println(s);
		}
	}
	
	/** du()
	 * Uses recursion to calculate the disk usage of the current 
	 * directory's files and the files in all of its subdirectories. 
	 */
	public void du() {
		long totalSize = current.du();
		System.out.println(totalSize + " characters");
	}
	
	/** pwd()
	 * Uses recursion to print the full directory path of the current directory.
	 */
	public void pwd() {
		String wd = current.pwd();
		if (wd.isEmpty()) {
			wd = "/";
		}
		System.out.println(wd);
	}
	
	/** find(String name)
	 * Using recursion, finds all files or directories named "name" and prints their full paths. 
	 * 
	 * @param name - the name that the user wishes to find files or directories named 
	 */
	public void find(String name) {
		current.find(name, current.pwd());
	}
	
	
	/**
	 * Prints the tree in an indent-formatted manner
	 */
	public void print() {
		root.print("", current);
	}
}
>>>>>>> 38d6b556e347050e44369f72fa3cc6e1f6ff23ba
