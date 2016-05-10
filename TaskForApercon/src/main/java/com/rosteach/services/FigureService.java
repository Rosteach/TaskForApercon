/**
 * @author Pavlenko R.A.
 */

package com.rosteach.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rosteach.beans.Figure;

public class FigureService {
	
	static HashMap<Integer,Figure> figureIdMap=getFigureIdMap();
	
	public FigureService(){
		super();
		if(figureIdMap==null){
			figureIdMap= new HashMap<Integer, Figure>();
			
			
			Figure triangle = new Figure(1,"Triangle","a*h/2");
			Figure circle = new Figure(2,"Circle","p*r*r");
			Figure rectangle = new Figure(3,"Rectangle","a*b");
			
			//add needed figures to our Collection
			figureIdMap.put(1, triangle);
			figureIdMap.put(2,circle);
			figureIdMap.put(3, rectangle);
		}
	}

	public static HashMap<Integer, Figure> getFigureIdMap(){
		return figureIdMap;
	}
	public static void setFigureIdMap(HashMap<Integer, Figure> figureIdMap) {
		FigureService.figureIdMap = figureIdMap;
	}

	//method for getting all our figures
	public List<Figure> getAllFigures(){
		List<Figure> figures = new ArrayList<Figure>(figureIdMap.values());
		return figures;
	}
	//method for getting one special figure
	public Figure getFigure(int id){
		Figure figure = figureIdMap.get(id);
		return figure;
	}
	//method for adding figures
	public Figure addFigure(Figure figure){
		figure.setId(figureIdMap.size()+1);
		figureIdMap.put(figure.getId(), figure);
		return figure;
	}
	
}
