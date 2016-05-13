/**
 * @author Pavlenko R.A.
 */
package com.rosteach.beans;

public class Figure {
	private String name;
	
	public Figure(){
	}
	public Figure(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//our method to override
	public double area(){
		return 0;
	}
}
