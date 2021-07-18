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
	 * The BufferedRead of class
	 */
	private BufferedReader reader;
	
	/**
	 * 
	 * @param path  file path 
	 */
	public Reader(String path) {
		try {
			this.reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read a list of symptom and return it
	 * @return a arrayList with symptom
	 */
	public ArrayList<Symptom> readSymptomDataFromFile() {
		ArrayList<Symptom> symptoms= new ArrayList<>();
		
		try {
			String line = reader.readLine();
			
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
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return symptoms;
	}


}
