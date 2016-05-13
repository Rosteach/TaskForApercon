/**
 * @author Pavlenko R.A.
 */
package com.rosteach.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rosteach.beans.Circle;
import com.rosteach.beans.Figure;
import com.rosteach.beans.Rectangle;
import com.rosteach.beans.Triangle;
import com.rosteach.services.FigureService;

@RestController
@RequestMapping(value = "/figures")
public class SecondTaskRestController {
	
	final Logger logger = LoggerFactory.getLogger(SecondTaskRestController.class);
	
	private FigureService figureService = new FigureService();
	
	//mapping our figures return list of All into Json format
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces={"application/json"})
	public List<Figure> getFigures(){
		List<Figure> listOfFigures = figureService.getAllFigures();
		return listOfFigures;
	}
	//return list of pre-calculated areas for each figure in the list above 
	@RequestMapping(value = "/listAllAreas", method = RequestMethod.GET, produces={"application/json"})
	public List<Double> getAllAreas(){
		List<Double> listOfAreas = figureService.getAllAreas();
		return listOfAreas;
	}
	//return special figure initialized by the index in our collection 
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces={"application/json"})
	public Figure findFigureById(@PathVariable Integer id) {
		return figureService.getFigure(id);
	}
	//add new figure, and return it if the request is successed else null expected
	@RequestMapping(value="/add", method=RequestMethod.POST, produces={"application/json"})
	public Figure createNew(@RequestBody String request){
		 
		String myFigureName = new Gson().fromJson(request, Figure.class).getName();  

		  if(myFigureName.equals("Triangle"))
		  {
			   Triangle triangle = new Gson().fromJson(request, Triangle.class);
			   figureService.addFigure(triangle);
			   return triangle;
		  }
		  else if(myFigureName.equals("Rectangle"))
		  {
			   Rectangle rectangle = new Gson().fromJson(request, Rectangle.class);
			   figureService.addFigure(rectangle);
			   return rectangle;
		  }
		  else if(myFigureName.equals("Circle"))
		  {
			   Circle circle = new Gson().fromJson(request, Circle.class);
			   figureService.addFigure(circle);
			   return circle;
		  }
		  else{
		   return null;
		  }
	}
}
