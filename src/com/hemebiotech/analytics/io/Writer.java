package com.hemebiotech.analytics.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.hemebiotech.analytics.Symptom;

/**
 * Class which will write to a file
 */
public class Writer {
	
	private FileWriter writer;
	
	/**
	 * 
	 * @param path file path 
	 */
	public Writer(String path) {
		try {
			this.writer =  new FileWriter(path);
		} catch (IOException e) {
			System.out.println("an error while opening the file has occured.");
		}
	}
	
	/**
	 * Saves a given symptom list and returns if the write was successful 
	 * @param symptoms A List of symptoms
	 * @return True if the operation was successful
	 */
	public boolean writeSymptomDataFromFile(ArrayList<Symptom> symptoms) {
		boolean success = true;
		if(writer == null ) {
			return false;
		}
		try {
			if(!(symptoms == null || symptoms.size() == 0)){
				for(Symptom symptom : symptoms) {
					writer.write(symptom.getName()+": "+symptom.getCount()+"\n");
				}
			}
		} catch (IOException e) {
			System.out.println("an error while writing the file has occured.");
			success = false;
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("an error while closing the file has occured.");
				success = false;
			}
		}
		return success;
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
