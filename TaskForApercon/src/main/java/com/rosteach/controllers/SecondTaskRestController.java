/**
 * @author Pavlenko R.A.
 */
package com.rosteach.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rosteach.beans.Figure;
import com.rosteach.services.FigureService;

@Controller
@RequestMapping(value = "/figures")
public class SecondTaskRestController {
	
	final Logger logger = LoggerFactory.getLogger(SecondTaskRestController.class);
	
	private FigureService figureService = new FigureService();
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public List<Figure> getFigures(){
		List<Figure> listOfFigures = figureService.getAllFigures();
		return listOfFigures;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public Figure findFigureById(@PathVariable Integer id) {
		return figureService.getFigure(id);
	}
	@RequestMapping(value="/", method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public Figure createNew(@RequestBody Figure figure){
		logger. info ( "Creating figure: " + figure);
		figureService.addFigure(figure);
		logger. info ( "Figure has created as: " + figure) ;
		return figure;
	}
}
