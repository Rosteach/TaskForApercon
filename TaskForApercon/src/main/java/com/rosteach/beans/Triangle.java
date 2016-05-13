package com.rosteach.beans;

public class Triangle extends Figure{
	private double height;
	private double side;
	
	public Triangle(){
		super();
	}
	public Triangle(String name,double h, double a){
		super(name);
		this.height=h;
		this.side=a;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public double area(){
		return height*side/2;
	}
}
