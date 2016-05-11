package com.rosteach.beans;

public class Circle extends Figure{
	
	private double radius;
	
	public Circle(){	
	}
	public Circle(int id, String name, double r){
		super();
		this.radius=r;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	//override area method
	public double area(){
		return Math.PI*(radius*radius);
	}
}
