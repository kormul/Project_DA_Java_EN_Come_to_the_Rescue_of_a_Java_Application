package com.hemebiotech.analytics.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.hemebiotech.analytics.Symptom;

public class Utils {
	
	/**
	 * sorted alphabetically a list of symptom 
	 * @param list of Symptoms
	 */
	public static void sortArrayListSymptoms(ArrayList<Symptom> list) {
		
		Collections.sort(list, new Comparator<Symptom>() {
			@Override
			public int compare(Symptom arg0, Symptom arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		});
	}

}
