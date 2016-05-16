/**
 * @author Pavlenko R.A.
 */

package com.rosteach.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rosteach.beans.Circle;
import com.rosteach.beans.Figure;
import com.rosteach.beans.Rectangle;
import com.rosteach.beans.Triangle;

public class FigureService {
	
	public static HashMap<Integer,Figure> figureIdMap=getFigureIdMap();
	
	public FigureService(){
		if(figureIdMap==null){
			figureIdMap= new HashMap<Integer, Figure>();
			
			
			Figure triangle = new Triangle(0,"Triangle", 2, 3);
			Figure circle = new Circle(1,"Circle",3);
			Figure rectangle = new Rectangle(2,"Rectangle",4,5);
			
			//add needed figures to our Collection
			figureIdMap.put(0, triangle);
			figureIdMap.put(1,circle);
			figureIdMap.put(2, rectangle);
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
		figure.setId(figureIdMap.size());
		figureIdMap.put(figure.getId(), figure);
		return figure;
	}
	//method for updating figures
	public Figure updateFigure(Figure figure){
		if(figure.getId()<0){
			return null;
		}
		else{
			figureIdMap.put(figure.getId(), figure);
			return figure;
		}
	}
	//method for delete figures
	public void deleteFigure(int id){
		figureIdMap.remove(id);
	}
	//method for calculate area
	public List<Double> getAllAreas(){
		List<Figure> figures = new ArrayList<Figure>(figureIdMap.values());
		List<Double> allAreas = new ArrayList<Double>();
		
		//get our list of Areas
		for(Figure figure: figures){
			allAreas.add(figure.area());
		}
		return allAreas;
	}
}
