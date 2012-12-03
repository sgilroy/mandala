package main;

import processing.core.PApplet;

public class BezierCurve {

	 float startX;
	  float startY;
	  float startZ;

	  float endX;
	  float endY;
	  float endZ;

	  float control1X;
	  float control1Y;
	  float control1Z;

	  float control2X;
	  float control2Y;
	  float control2Z;

	  BezierCurve(float sX, float sY, float sZ,Point3d c1, Point3d c2,float eX, float eY, float eZ) {

	    startX =sX;
	    startY =sY;
	    startZ =sZ;

	    endX =eX;
	    endY = eY;
	    endZ=eZ;

	    control1X = c1.x;
	    control1Y = c1.y;
	    control1Z = c1.z;

	    control2X = c2.x;
	    control2Y = c2.y;
	    control2Z = c2.z;
	  } 
	  
	  Point3d getClosestPoint(PApplet parent, Point3d targetPoint, float rez){
	   //Point3d [] bezPoints = new Point3d[rez];
	   Point3d chosenPoint = null;
	    float distance = 100000000;
	    for(int i=0;i<rez;i++){
	      float t = i / (rez);
	      float x = parent.bezierPoint(startX, control1X, control2X, endX, t);
	      float y = parent.bezierPoint(startY, control1Y, control2Y, endY, t);
	      float z = parent.bezierPoint(startZ, control1Z, control2Z, endZ, t);
	      
	      Point3d bezPoint = new Point3d(x,y,z);
	      
	      float d = bezPoint.distTo(targetPoint);
	      //println(d);
	      if (d< distance){
	          chosenPoint = bezPoint;
	          distance = d;
	          //println("min found at"+d);
	      }
	     }
	     return chosenPoint;
	    
	  }
	  
	  Point3d pointAt(PApplet parent, float rez, int at){
	   //Point3d [] bezPoints = new Point3d[rez];

	   
	      float t = at / (rez);
	      float x = parent.bezierPoint(startX, control1X, control2X, endX, t);
	      float y = parent.bezierPoint(startY, control1Y, control2Y, endY, t);
	      float z = parent.bezierPoint(startZ, control1Z, control2Z, endZ, t);
	      
	      Point3d bezPoint = new Point3d(x,y,z);
	   
	     return bezPoint;
	    
	  }
	  
	  void drawControlPoints(PApplet parent){
		   parent.strokeWeight(5);
		    parent.stroke(255,0,0);
		   parent.point(startX,startY,startZ);
		   parent.point(endX,endY,endZ);
		   parent.stroke(0,255,0);

		   parent.point(control1X,control1Y,control1Z);
		   parent.point(control2X,control2Y,control2Z);
	  }

	  void draw(PApplet parent) {
	 
	   
	    parent.bezier(startX, startY, startZ, control1X, control1Y, control1Z, control2X, control2Y, control2Z, endX, endY, endZ);
	  }
	
}
