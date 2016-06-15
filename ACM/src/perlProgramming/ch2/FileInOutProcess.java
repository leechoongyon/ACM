package perlProgramming.ch2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInOutProcess
{
	public static BufferedReader FileInputProcess(String filePath)
	{
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return in;
	}

	public static BufferedWriter FileOutputProcess(String filePath)
	{
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
}

