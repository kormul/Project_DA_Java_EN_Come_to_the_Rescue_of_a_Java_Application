package com.hemebiotech.analytics.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.hemebiotech.analytics.Symptom;

/**
 * Class which will write to a file
 */
public class Writer {
	
	FileWriter writer;
	
	/**
	 * 
	 * @param path file path 
	 */
	public Writer(String path) {
		try {
			this.writer =  new FileWriter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves a given symptom list and returns if the write was successful 
	 * @param symptoms A List of symptoms
	 * @return True if the operation was successful
	 */
	public boolean writeSymptomDataFromFile(ArrayList<Symptom> symptoms) {
		try {
			if(symptoms == null || symptoms.size() == 0) {
				writer.close();
				return true;
			}
			
			for(Symptom symptom : symptoms) {
				writer.write(symptom.getName()+": "+symptom.getCount()+"\n");
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	 
	/**
	 * Gets FIleWritter
	 * @return FileWritter
	 */
	public FileWriter getWriter() {
		return writer;
	}
	
	/**
	 * Set FillWritter
	 * @param writer New FileWritter
	 */
	public void setWriter(FileWriter writer) {
		this.writer = writer;
	}
	
}
