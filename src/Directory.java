<<<<<<< HEAD
import java.util.ArrayList;

/**
 * file name: Directory.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a directory as a node that can contain files or directories, and contains functions of directories.
 */

public class Directory extends Node {
	private ArrayList<File> files = new ArrayList<File>();
	private ArrayList<Directory> directories = new ArrayList<Directory>();
	
	public Directory(String dirName) {
		name = dirName;
		isFile = false;
		isDir = true;
	}
	
	/**
	 * Checks if list of files is empty
	 */
	public boolean isFilesEmpty() {
		return files.isEmpty();
	}
	
	/**
	 * Checks if list of directories is empty 
	 */
	public boolean isDirsEmpty() {
		return directories.isEmpty();
	}
	
	/**
	 * Gets a file with the given name from the list of files, if it can be found
	 */
	public File getFile(String name) {
		for (File f: files) {
			if (f.name.equals(name)) {
				return f;
			}
		}
		return null;
	}
	
	/**
	 * Gets a directory with the given name from the list of directories, if it can be found
	 */
	public Directory getDir(String name) {
		for (Directory d: directories) {
			if (d.name.equals(name)) {
				return d;
			}
		}
		return null;
	}
	
	/**
	 * Returns true if list of files contains file with given name, false otherwise
	 */
	public boolean containsFile(String name) {
		File f = getFile(name);
		return f != null;
	}
	
	/**
	 * Returns true if list of directories contains directory with given name, false otherwise
	 */
	public boolean containsDir(String name) {
		Directory d = getDir(name);
		return d != null;
	}
	
	/**
	 * Adds a file to the list of files
	 */
	public void addFile(File file) {
		files.add(file);
	}
	
	/**
	 * Adds a directory to the list of directories
	 */
	public void addDir(Directory dir) {
		directories.add(dir);
	}
	
	/**
	 * If file with given name can be found, it is removed from list of files
	 */
	public void removeFile(String name) {
		File f = getFile(name);
		if (f != null) {
			files.remove(f);
		}
	}
	
	/**
	 * If directory with given name can be found, it is removed from list of directories
	 */
	public void removeDir(String name) {
		Directory d = getDir(name);
		if (d != null) {
			directories.remove(d);
		}
	}
	
	
	/** fdsort()
	 * Alphabetizes names of all files and directories in the current directory using a bubble sort
	 */
	protected String[] fdsort() {
		String[] sorted = new String[files.size() + directories.size()];
		// adding names of files and directories to array
		for(int a = 0; a < files.size(); a++) {
			sorted[a] = files.get(a).name;
		}
		for(int b = 0; b < directories.size(); b++) {
			sorted[files.size() + b] = directories.get(b).name + " (*)";
		}
				
		// Bubble sort to reorder the elements of the array in alphabetical manner
		for(int i = sorted.length - 1; i > 0; --i) {
			for(int j = 1; j <= i; j++) {
				if (sorted[j-1].compareTo(sorted[j]) > 0) {
					final String tmp = sorted[j-1];
					sorted[j-1] = sorted[j];
					sorted[j] = tmp;
				}
			}
		}
		return sorted;
	}
	
	
	/** du(Directory dir)
	 * Helper method for du()
	 * 
	 * @returns - the cumulative size of all files in current and subdirectories (in characters)
	 */
	public long du() {
		int size = 0;
		
		for(File f : files) { // getting size of files in current directory
			size += f.getLength();
		}
		for(Directory d : directories) { // calling itself on each subdirectory 
			size += d.du();
		}
		
		return size;
	}
	
	
	/**	pwd(Directory dir)
	 * Helper method for pwd()
	 * 
	 * @returns - the full directory path of the node
	 */
	public String pwd() {
		if (name.equals("/")) { // base case: the directory is root
			return "";
		}
		else {
			return getParent().pwd() + "/" + name;
		}
	}
	
	
	/** find(Directory dir, String name, String path)
	 * Helper method for find(String name)
	 * 
	 * @param name - the name to search for
	 * @param path - the path of the file/directory to return (if it is found)
	 */
	public void find(String name, String path) {
		File f = getFile(name);
		if(f != null) {
			System.out.println(path + "/" + f.name);
		}
		
		Directory dir = getDir(name);
		if(dir != null) {
			System.out.println(path + "/" + dir.name);
		}

		for(Directory d : directories) {
			d.find(name, path + "/" + d.name);
		}	
	}
	
	/** print()
	 * Prints the tree in an indented format, used for testing to have easy visualization of the tree
	 * @param indent - 3 spaces, used to format the tree
	 * @param current - The current directory
	 */
	public void print(String indent, Directory current) {
		System.out.printf("%s/ %s %s\n", indent, name.equals("/") ? "" : name, this == current ? "<--" : "");
		for (Directory d: directories) {
			d.print(indent + "  ", current);
		}
		for (File f: files) {
			System.out.printf("%s  -%s: %s\n", indent, f.name, ""/*f.getContents()*/);
		}
	}	
}
=======
import java.util.ArrayList;

/**
 * file name: Directory.java
 * @author Gabriel Zubovsky
 * Purpose: Defines a directory as a node that can contain files or directories, and contains functions of directories.
 */

public class Directory extends Node {
	private ArrayList<File> files = new ArrayList<File>();
	private ArrayList<Directory> directories = new ArrayList<Directory>();
	
	public Directory(String dirName) {
		name = dirName;
		isFile = false;
		isDir = true;
	}
	
	/**
	 * Checks if list of files is empty
	 */
	public boolean isFilesEmpty() {
		return files.isEmpty();
	}
	
	/**
	 * Checks if list of directories is empty 
	 */
	public boolean isDirsEmpty() {
		return directories.isEmpty();
	}
	
	/**
	 * Gets a file with the given name from the list of files, if it can be found
	 */
	public File getFile(String name) {
		for (File f: files) {
			if (f.name.equals(name)) {
				return f;
			}
		}
		return null;
	}
	
	/**
	 * Gets a directory with the given name from the list of directories, if it can be found
	 */
	public Directory getDir(String name) {
		for (Directory d: directories) {
			if (d.name.equals(name)) {
				return d;
			}
		}
		return null;
	}
	
	/**
	 * Returns true if list of files contains file with given name, false otherwise
	 */
	public boolean containsFile(String name) {
		File f = getFile(name);
		return f != null;
	}
	
	/**
	 * Returns true if list of directories contains directory with given name, false otherwise
	 */
	public boolean containsDir(String name) {
		Directory d = getDir(name);
		return d != null;
	}
	
	/**
	 * Adds a file to the list of files
	 */
	public void addFile(File file) {
		files.add(file);
	}
	
	/**
	 * Adds a directory to the list of directories
	 */
	public void addDir(Directory dir) {
		directories.add(dir);
	}
	
	/**
	 * If file with given name can be found, it is removed from list of files
	 */
	public void removeFile(String name) {
		File f = getFile(name);
		if (f != null) {
			files.remove(f);
		}
	}
	
	/**
	 * If directory with given name can be found, it is removed from list of directories
	 */
	public void removeDir(String name) {
		Directory d = getDir(name);
		if (d != null) {
			directories.remove(d);
		}
	}
	
	
	/** fdsort()
	 * Alphabetizes names of all files and directories in the current directory using a bubble sort
	 */
	protected String[] fdsort() {
		String[] sorted = new String[files.size() + directories.size()];
		// adding names of files and directories to array
		for(int a = 0; a < files.size(); a++) {
			sorted[a] = files.get(a).name;
		}
		for(int b = 0; b < directories.size(); b++) {
			sorted[files.size() + b] = directories.get(b).name + " (*)";
		}
				
		// Bubble sort to reorder the elements of the array in alphabetical manner
		for(int i = sorted.length - 1; i > 0; --i) {
			for(int j = 1; j <= i; j++) {
				if (sorted[j-1].compareTo(sorted[j]) > 0) {
					final String tmp = sorted[j-1];
					sorted[j-1] = sorted[j];
					sorted[j] = tmp;
				}
			}
		}
		return sorted;
	}
	
	
	/** du(Directory dir)
	 * Helper method for du()
	 * 
	 * @returns - the cumulative size of all files in current and subdirectories (in characters)
	 */
	public long du() {
		int size = 0;
		
		for(File f : files) { // getting size of files in current directory
			size += f.getLength();
		}
		for(Directory d : directories) { // calling itself on each subdirectory 
			size += d.du();
		}
		
		return size;
	}
	
	
	/**	pwd(Directory dir)
	 * Helper method for pwd()
	 * 
	 * @returns - the full directory path of the node
	 */
	public String pwd() {
		if (name.equals("/")) { // base case: the directory is root
			return "";
		}
		else {
			return getParent().pwd() + "/" + name;
		}
	}
	
	
	/** find(Directory dir, String name, String path)
	 * Helper method for find(String name)
	 * 
	 * @param name - the name to search for
	 * @param path - the path of the file/directory to return (if it is found)
	 */
	public void find(String name, String path) {
		File f = getFile(name);
		if(f != null) {
			System.out.println(path + "/" + f.name);
		}
		
		Directory dir = getDir(name);
		if(dir != null) {
			System.out.println(path + "/" + dir.name);
		}

		for(Directory d : directories) {
			d.find(name, path + "/" + d.name);
		}	
	}
	
	/** print()
	 * Prints the tree in an indented format, used for testing to have easy visualization of the tree
	 * @param indent - 3 spaces, used to format the tree
	 * @param current - The current directory
	 */
	public void print(String indent, Directory current) {
		System.out.printf("%s/ %s %s\n", indent, name.equals("/") ? "" : name, this == current ? "<--" : "");
		for (Directory d: directories) {
			d.print(indent + "  ", current);
		}
		for (File f: files) {
			System.out.printf("%s  -%s: %s\n", indent, f.name, ""/*f.getContents()*/);
		}
	}	
}
>>>>>>> 38d6b556e347050e44369f72fa3cc6e1f6ff23ba
