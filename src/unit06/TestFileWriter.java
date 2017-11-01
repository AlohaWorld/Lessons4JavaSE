package unit06;

import java.io.*;

public class TestFileWriter {
	public static void main(String[] args) /*throws IOException*/ {
	  try {
		// Create an output stream to the file
		FileWriter output = new FileWriter("temp.txt", true);

		// Output a string to the file
		output.write("Introduction to Java");

		// Close the stream
		output.close();
	  }
	  catch (IOException ex) {
	    ex.printStackTrace();
	  }
	}
}
