package com.rosteach.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rosteach.beans.Figure;
import com.rosteach.services.FigureService;

@Path("/figures")
public class SecondTaskRestController {
	
	FigureService figureService = new FigureService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Figure> getFigures(){
		List<Figure> listOfFigures = figureService.getAllFigures();
		return listOfFigures;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Figure getFigureById(@PathParam("id") int id){
		return figureService.getFigure(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Figure addFigure(Figure figure){
		return figureService.addFigure(figure);
	}
	
}
