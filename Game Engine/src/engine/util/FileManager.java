package engine.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
	String path;
	File file;
	BufferedReader in;
	BufferedWriter out;

	public FileManager(String path) {
		this.path = path;

		try {
			file = new File(path);
			file.createNewFile();
			file.setReadable(true);
			file.setWritable(true);
			
			in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
		} catch(Exception e) {
			System.out.println("Failed to load streams for file: " + path);
		}
	}
	
	/**
	 * Deletes the file and creates a new file by the same name.
	 */
	public void clearFile() {
		try {
			file.delete();
			file.createNewFile();
		} catch(Exception e) {
			System.out.println("Failed to clear file: " + path);
		}
	}

	/**
	 * Returns all the lines of a given file separated into an array list.
	 * @return
	 */
	public ArrayList<String> readLines() {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			String line = in.readLine();
			
			while(line != null) {
				lines.add(line);
				line = in.readLine();
			}
		} catch(Exception e) {
			System.out.println("Failed to read file: " + path);
		}
		
		return lines;
	}

	/**
	 * Writes the specified line into a file at the end.
	 * @param line
	 */
	public void writeLine(String line) {
		try {
			out.write(line);
			out.newLine();
			out.flush();
		} catch(Exception e) {
			System.out.println("Failed to write to file: " + path);
		}
	}
}
