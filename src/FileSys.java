import java.io.FileInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * File name: FileSys.java
 * @author Gabriel Zubovsky
 * Purpose: Use recursion and trees to implement a model of a computer's file 
 * system and a simple version of a terminal window that can be used by a human.
 */

public class FileSys {
	public static void main(String[] args) {
		try {
			// option to test by inputting file name in command-line, or run as normal taking user input
			boolean fromFile = (args.length > 0);
			InputStream in = fromFile ? new FileInputStream(args[0]) : System.in;
			
	        try (Scanner scanLine = new Scanner(in)) {
				Tree tree = new Tree();
				String command = "";
				String argument = "";
	
				do {
					System.out.print("prompt> ");
					String nextline = scanLine.nextLine();
					
					if (fromFile) System.out.println(nextline);
					
					// checking for non-null, non-empty, and non-whitespace input
					if (nextline != null && !nextline.isBlank()) {
						String[] input = nextline.split("\s+");
						
						command = input[0];
						if(input.length > 1) {
							argument = input[1];
						}
						
						// switch statement with cases for each type of command the user can issue
						switch (command) {
						case "create":
							if (input.length < 2) {
								System.out.println("ERROR: file name required for command " + command);
							}
							else {
								File file = tree.create(argument);
								
								if (file != null) {	 // file is !null only if user command passes all error checks
									String contents = "";
									while(true) {
										String line = scanLine.nextLine();
										int tildeIndex = line.indexOf('~');
										if (tildeIndex < 0) {
											contents = contents.concat(line + "\n"); 
											// if no tilde, scans line and adds linebreak
										}
										else {
											contents = contents.concat(line.substring(0, tildeIndex)); 
											break;			// if tilde, concats text before tilde
										}
									}
									file.setContents(contents);
								}
							}
							break;
							
						case "cat":
							if (input.length < 2) {
								System.out.println("ERROR: file name required for command " + command);
							}
							else {
								tree.cat(argument);
							}
							break;
							
						case "rm":
							if (input.length < 2) {
								System.out.println("ERROR: file name required for command " + command);
							}
							else {
								tree.rm(argument);
							}
							break;
							
						case "mkdir":
							if (input.length < 2) {
								System.out.println("ERROR: directory name required for command " + command);
							}
							else {
								tree.mkdir(argument);
							}
							break;
						
						case "rmdir":
							if (input.length < 2) {
								System.out.println("ERROR: directory name required for command " + command);
							}
							else {
								tree.rmdir(argument);
							}
							break;
							
						case "cd":
							if (input.length < 2) {
								System.out.println("ERROR: directory name required for command " + command);
							}
							else {
								tree.cd(argument);
							}
							break;
							
						case "ls":
							tree.ls();						
							break;
							
						case "du":
							tree.du();
							break;
			 
						case "pwd":
							tree.pwd();
							break;
							
						case "find":
							if (input.length < 2) {
								System.out.println("ERROR: file/directory name required for command " + command);
							}
							else {
								tree.find(argument);
							}
							break;
							
						case "exit":
							break;
	
						case "tree": 		// method used for testing purposes, to print out 
							tree.print();	// visual representation of the tree of nodes
							break;
							
						default:
							System.out.println("ERROR: Unknown command " + command);
						}
					}
				} while (!command.equals("exit")); // breaks loop when command is exit
			}
	        catch (NoSuchElementException e) {
	        	System.out.println("exit");
	        }
		}
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
