/**
 * @author Pavlenko R.A.
 */
package com.rosteach.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.rosteach.beans.Circle;
import com.rosteach.beans.Figure;
import com.rosteach.beans.Rectangle;
import com.rosteach.beans.Triangle;
import com.rosteach.controllers.SecondTaskRestController;
import com.rosteach.services.FigureService;

public class FigureValidation{
	private FigureService figureService = new FigureService();
	// method for validation of input figure  
	public Figure validateFigure(String request,String figureName) {
		
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
	public ResponseEntity<Figure> validateResponse(Figure figure, String figureName, String request){
		final Logger logger = LoggerFactory.getLogger(SecondTaskRestController.class);
		
		if(figure==null){
			//logger
			logger.info("HttpStatus.NOT_FOUND");
			return new ResponseEntity<Figure>(HttpStatus.NOT_FOUND);
		}
		else if(figureName!=null){
			//logger
			logger.info("Figure with parameters [id: "+figure.getId()+"],[name: "+figureName+"] updated successfully!!");
			//validate input figure
			FigureValidation check = new FigureValidation();
			Figure tempFigure = check.validateFigure(request,figureName);
			
			figureService.updateFigure(tempFigure);
			return new ResponseEntity<Figure>(tempFigure, HttpStatus.OK);
		}
		else{
			//logger
			logger.info("HttpStatus.BAD_REQUEST");
			
			return new ResponseEntity<Figure>(HttpStatus.BAD_REQUEST);
		}
	};
}
