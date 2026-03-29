# SimulFileSys

A Java-based file system simulator that demonstrates tree data structures and recursion principles.

## Description

SimulFileSys is an educational project that models a computer's file system using a tree of nodes. It provides a terminal-like interface where users can interact with a simulated file system using familiar Unix/Linux-style commands. The project showcases practical implementations of recursion, tree traversal, and data structure manipulation.

## Features

- **File Operations**: Create and remove files with text content
- **Directory Management**: Create, navigate, and remove directories
- **File System Navigation**: Change directories with support for absolute and relative paths
- **Search Functionality**: Find files and directories by name recursively
- **Disk Usage Calculation**: Compute total size of files in a directory and its subdirectories
- **Directory Listing**: List files and directories in alphabetical order
- **Path Display**: Show the current working directory path

## Commands

| Command | Usage | Description |
|---------|-------|-------------|
| `create <filename>` | `create myfile.txt` | Create a new file and add content (end input with `~`) |
| `cat <filename>` | `cat myfile.txt` | Display file contents |
| `rm <filename>` | `rm myfile.txt` | Remove a file |
| `mkdir <dirname>` | `mkdir myfolder` | Create a new directory |
| `rmdir <dirname>` | `rmdir myfolder` | Remove a directory and its contents |
| `cd <path>` | `cd myfolder` or `cd /` | Change directory (supports `..` for parent) |
| `ls` | `ls` | List files and directories in current directory |
| `pwd` | `pwd` | Print current working directory path |
| `du` | `du` | Display total size (in characters) of all files in current directory and subdirectories |
| `find <name>` | `find myfile` | Find all files/directories with the given name and display their paths |
| `exit` | `exit` | Exit the file system simulator |

## Project Structure
