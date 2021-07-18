package com.hemebiotech.analytics.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.hemebiotech.analytics.Symptom;

/**
 * Class that will store and read a BufferedReader
 */

public class Reader {
	
	/**
	 * The path of the file 
	 */
	
	private String path;
	/**
	 * 
	 * @param path  file path 
	 */
	public Reader(String path) {
		this.setPath(path);
	}
	
	/**
	 * Read a list of symptom and return it
	 * @return a arrayList with symptom
	 */
	public ArrayList<Symptom> readSymptomDataFromFile() {
		
		ArrayList<Symptom> symptoms= new ArrayList<>();
		
			FileReader file;
			try {
				file = new FileReader(path);
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				return symptoms;
			}
		
			BufferedReader reader = new BufferedReader(file);

			String line;
			try {
				
				line = reader.readLine();
				while(line != null) {
					boolean check = true;
					for(Symptom symptom : symptoms) {
						if(symptom.getName().equalsIgnoreCase(line)) {
							check = false;
							symptom.setCount(symptom.getCount()+1);
						}

					}
					if(check) {
						symptoms.add(new Symptom(line));
					}
					
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println("an error while reading the file has occurred.");
			}
			finally{
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("an error while closing the file has occurred.");
				}
			}
		return symptoms;
	}
	
	/**
	 * Gets path
	 * @return path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set path
	 * @param New path
	 */
	public void setPath(String path) {
		this.path = path;
	}


}
