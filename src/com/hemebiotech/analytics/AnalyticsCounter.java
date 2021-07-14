package com.hemebiotech.analytics;

import java.util.ArrayList;

import com.hemebiotech.analytics.io.Reader;
import com.hemebiotech.analytics.io.Writter;

public class AnalyticsCounter {
	
	
	public static void main(String args[]) throws Exception {
		
		//Create a symptom list from the symptom read file 
		ArrayList<Symptom> symptoms = new Reader("symptoms.txt").readSymptomDataFromFile();
		
		//Writes the symptoms to an output file to record
		new Writter("result.out").writeSymptomDataFromFile(symptoms);
		
	}
}
