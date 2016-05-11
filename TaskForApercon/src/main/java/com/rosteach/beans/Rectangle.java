package com.rosteach.beans;

public class Rectangle extends Figure{
	private double height;
	private double width;
	
	public Rectangle(){
		
	}
	public Rectangle(int id,String name,double h, double w){
		super();
		this.height=h;
		this.width=w;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//@Override area method
	public double area(){
		return height*width;
	}
}
