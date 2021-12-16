package io;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static java.nio.file.Files.createFile;

public class InputOutput {
	public static void main(String[] args) {
		InputOutput.ioFilesOnFileSystem();
		InputOutput.ioFilesInResources();
		System.out.println("Scanning file");
		InputOutput.ioFilesOnFileSystemScanner();
	}
	
	private static void ioFilesOnFileSystemScanner() {
		File file = InputOutput.createFile();
		
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				System.out.println(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static File createFile() {
		File file = new File("test.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write("Hello\nWorld");
				writer.close(); // Flushes the stream (does the write)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	static void ioFilesInResources() {
		try {
			ClassLoader classLoader = InputOutput.class.getClassLoader();
			URL resourceUrl = classLoader.getResource("resource_file.txt");
			InputStream s = resourceUrl.openStream();
			byte[] bytes = s.readAllBytes();
			System.out.println("Reading file content from resource stream bytes: " + new String(bytes));
			s.close();
			File file = new File(resourceUrl.getFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			System.out.println("Reading file content from file reader: " + reader.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void ioFilesOnFileSystem() {
		File file = new File("test.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write("Hello\nWorld");
				writer.close(); // Flushes the stream (does the write)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file.getName()))) {
			String line = reader.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file.delete();
	}
}
