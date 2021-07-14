package com.hemebiotech.analytics;

/**
	This class stores the name of the symptom as well as its counter 
 */

public class Symptom {
	
	private String name;
	private int count;
	
	/**
	 Constructor for the case of a new symptom.
	 @param name Name of new symptom.
	 */
	public Symptom(String name) {
		this.name = name;
		this.count = 1;
	}

	/**
	   Gets Name of Symptom
	   @return Name of Symptom
	 */
	public String getName() {
		return name;
	}

	/**
	  Sets the Name of Symptom
	  @param name New name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	   Get the number of symptom
	   @return Counter of symptom
	 */

	public int getCount() {
		return count;
	}
	
	/**
	  Set the number of sympom
	  @param count New counter
	 */

	public void setCount(int count) {
		this.count = count;
	}
}
