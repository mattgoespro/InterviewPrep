package io;

import java.io.*;

public class InputOutput {
	public static void main(String[] args) {
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
