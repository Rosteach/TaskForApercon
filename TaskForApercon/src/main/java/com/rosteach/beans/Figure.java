/**
 * @author Pavlenko R.A.
 */
package com.rosteach.beans;

public class Figure {
	private int id;
	private String name;
	
	public Figure(){
	}
	public Figure(int id, String name){
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
