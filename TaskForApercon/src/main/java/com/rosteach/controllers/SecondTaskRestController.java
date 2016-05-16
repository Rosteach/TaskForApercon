/**
 * @author Pavlenko R.A.
 */
package com.rosteach.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rosteach.beans.Figure;
import com.rosteach.services.FigureService;
import com.rosteach.validation.FigureValidation;

@RestController
@RequestMapping(value = "/figures")
public class SecondTaskRestController{
	
	private static final Logger logger = LoggerFactory.getLogger(SecondTaskRestController.class);
	
	private FigureService figureService = new FigureService();
	
	//mapping our figures return list of All into Json format
	@RequestMapping(value = "/", method = RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<List<Figure>> getFigures(){
		List<Figure> listOfFigures = figureService.getAllFigures();
		return new ResponseEntity<List<Figure>>(listOfFigures,HttpStatus.OK);
	}
	
	//return list of pre-calculated areas for each figure in the list above 
	@RequestMapping(value = "/areas", method = RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<List<Double>> getAllAreas(){
		List<Double> listOfAreas = figureService.getAllAreas();
		return new ResponseEntity<List<Double>>(listOfAreas, HttpStatus.OK);
	}
	
	//return special figure initialized by the index in our collection 
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<Figure> findFigureById(@PathVariable Integer id){
		return new ResponseEntity<Figure>(figureService.getFigure(id), HttpStatus.OK);
	}
	
	//ADD(POST) new figure, and return it if the request is successed else null expected
	@RequestMapping(value="/add", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<Figure> add(@RequestBody String request){
		 System.out.println(request);
		String myFigureName = new Gson().fromJson(request, Figure.class).getName();  
		
		//validate our input figure
		FigureValidation check = new FigureValidation();
		Figure figure = check.validateFigure(request,myFigureName);
		
		//add new figure
		figureService.addFigure(figure);
		
		return new ResponseEntity<Figure>(figure, HttpStatus.OK);
	}
	
	//DELETE(DELETE) figure by id 
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces={"application/json"})
	public ResponseEntity<List<Figure>> deleteFigure(@PathVariable int id){
		figureService.deleteFigure(id);
		List<Figure> listOfFigures = figureService.getAllFigures();
		return new ResponseEntity<List<Figure>>(listOfFigures,HttpStatus.OK);
	}
	
	//UPDATE(PUT) existing figure with method PUT
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, produces={"application/json"})
	public ResponseEntity<Figure> updateFigure(@PathVariable int id,@RequestBody String request){
		
		Figure tempFigure = figureService.getFigure(id);
		String tempFigureName = new Gson().fromJson(request, Figure.class).getName();
		
		FigureValidation check = new FigureValidation();
		
		ResponseEntity<Figure> response = check.validateResponse(tempFigure, tempFigureName, request);
		/*//check if exist
		if(tempFigure==null){
			//logger
			logger.info("HttpStatus.NOT_FOUND");
			
			return new ResponseEntity<Figure>(HttpStatus.NOT_FOUND);
		}
		else if(tempFigureName!=null){
			//logger
			logger.info("Figure with parameters [id: "+tempFigure.getId()+"],[name: "+tempFigureName+"] updated successfully!!");
			//validate input figure
			Figure figure = check.validateFigure(request,tempFigureName);
			
			figureService.updateFigure(figure);
			return new ResponseEntity<Figure>(figure, HttpStatus.OK);
		}
		else{
			//logger
			logger.info("HttpStatus.BAD_REQUEST");
			
			return new ResponseEntity<Figure>(HttpStatus.BAD_REQUEST);
		}*/
		return response;
	}
}
