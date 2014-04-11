package br.github.gnomex.some_examples.lista_exercicios.geometry;

import java.awt.Point;

public class Geometry {

	private static final float twoPI = (float) 6.28;  
	
	public static Float circleArea(Integer distance)	{
		return new Float( twoPI * distance );
	}
	
	public static Integer getDistanceBetwenTwoPoints(Point p1, Point p2)	{
		Double x = p2.getX() - p1.getX();
		Double y = p2.getY() - p1.getY();
		
		Double d = Math.sqrt(x*x + y*y);
		
		return new Integer(d.intValue());
	}
	
}
