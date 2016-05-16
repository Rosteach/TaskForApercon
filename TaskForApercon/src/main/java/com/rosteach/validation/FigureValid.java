/**
 * @author Pavlenko R.A.
 */
package com.rosteach.validation;

import com.google.gson.Gson;
import com.rosteach.beans.Circle;
import com.rosteach.beans.Figure;
import com.rosteach.beans.Rectangle;
import com.rosteach.beans.Triangle;

public class FigureValid{
	// method for validation of input figure  
	public Figure validate(String request,String figureName) {
		
		if(figureName.equals("Triangle")){
			Triangle triangle = new Gson().fromJson(request, Triangle.class);
			return triangle;
		}
		else if(figureName.equals("Rectangle")){
			Rectangle rectangle = new Gson().fromJson(request, Rectangle.class);
			return rectangle;
		}
		else if(figureName.equals("Circle")){
			Circle circle = new Gson().fromJson(request, Circle.class);
			return circle;
		}
		else{
			return null;
		}
	}
	// method for validation Response entity
}
