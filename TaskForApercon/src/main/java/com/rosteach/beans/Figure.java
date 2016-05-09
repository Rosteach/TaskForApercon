/**
 * @author Pavlenko R.A.
 */
package com.rosteach.beans;

public class Figure {
	int id;
	String name;
	String square;
	
	public Figure(){
		super();
	}
	public Figure(int id, String name, String square){
		super();
		this.id=id;
		this.name=name;
		this.square=square;
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
	public String getSquare() {
		return square;
	}
	public void setSquare(String square) {
		this.square = square;
	}
}
