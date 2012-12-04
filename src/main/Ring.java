package main;

import processing.core.PApplet;

public class Ring {
	private int num;
	private float height;
	private float offset;
	private float cDist;
	private float startX;
	private float startY;
	private float endX;
	private float endY;
	float startZ = 0;
	private Point3d c1;
	private Point3d c2;
	private boolean flip1;
	private boolean flip2;
	private float strokeWeight;
	BezierCurve bez;
	private boolean autoMirror = false;

	public Ring(){
	
		startX =0;
		startY= 0;
		setWidth(100);
		height = 100;
		offset=0;
		num=5;
		cDist=0;
		c1 = new Point3d(startX+(getWidth() *0.25f),startY- (getHeight() *0.5f),0.0f);
		c2 = new Point3d(startX+(getWidth() *0.25f),startY+ (getHeight() *0.5f),0.0f);
		flip1=false;
		flip2=false;
		this.strokeWeight = 5.0f;
	} 
	
	public void setNumber(int num){
		this.num=num;
	}

	public void setWidth(float width){
		endX = startX + width;
		endY = startY;
	}

	public void setHeight(float height){
		this.height = height;
		c1.y = startY- (height*0.5f);
		c2.y = startY+ (height*0.5f);
		if(this.flip1){
			flip(c1);
			
		}
		if(this.flip2){
			flip(c2);
			
		}
	}
	
	public void setRotationOffset(float offset){
		this.offset = offset;
		
	}
	
	public void setCenterOffset(float coffset){
		this.cDist = coffset;
		
	}
	
	/**
	 * Sets the position of the start point of the curve. Changing the position of the start point will not affect the
	 * end point.
	 * @param x the x coordinate of the start point
	 * @param y the y coordinate of the start point
	 */
	public void setStartPoint(float x, float y){
		this.startX=x;
		this.startY=y;
	}

	/**
	 * Sets the position of the end point of the curve.
	 * @param x the x coordinate of the end point
	 * @param y the y coordinate of the end point
	 */
	public void setEndPoint(float x, float y){
		this.endX = x;
		this.endY = y;
	}
	
	public void setStartCurvePoint(float x, float y){
		this.c1.x=x;
		this.c1.y=y;
		
	}
	
	public void setEndCurvePoint(float x, float y){
		this.c2.x=x;
		this.c2.y=y;
		
	}
	public void flipStart(){
		
		flip(c1);
		this.flip1=true;
	}
	
	public void flipEnd(){
		
		flip(c2);
		this.flip2 = true;
	}
	
	public void flip(Point3d c){
		c.y*=-1;
		
	}
	
	public void setStrokeWeight(float weight){
		this.strokeWeight = weight;
	}
	
	public void set(int num, float width, float height, float centerOffset, float rotationOffset, float strokeWeight, boolean flip1, boolean flip2){
			this.num = num;
			this.setWidth(width);
			this.setHeight(height);
			this.cDist = centerOffset;
			this.offset = rotationOffset;
			this.flip1=flip1;
			this.flip2=flip2;
			this.strokeWeight = strokeWeight;
			if(flip1){
				flip(c1);
				
			}
			if(flip2){
				flip(c2);
				
			}
	}
	
	public void generate (){
		bez = new BezierCurve(startX, startY, startZ, c1, c2, endX, endY, startZ);
	}

	public void draw(PApplet parent){
		this.generate();
		  parent.noFill();
		  parent.strokeWeight(this.strokeWeight);
//		  parent.stroke(0);
		  for(int i=0;i<num;i++){
		   parent.pushMatrix();
		   parent.translate(parent.width/2,parent.height/2,0);
		   parent.rotateZ((float)(2*Math.PI/num)*i+offset);
		   parent.translate(cDist,0,0);
		   
		    bez.draw(parent);
		    parent.popMatrix();
		    
		  }

		if (isAutoMirror())
		{
			Ring mirror = this.mirror();
			mirror.setAutoMirror(false);
			mirror.draw(parent);
		}
	}
	
	public Ring mirror(){
		Ring mirror = new Ring();
		mirror.set(this.num, this.getWidth(), this.getHeight(), this.cDist, this.offset,this.strokeWeight, !flip1,!flip2);
		mirror.setStartPoint(startX, -startY);
		mirror.setEndPoint(endX, -endY);
		mirror.setStartCurvePoint(c1.x, -c1.y);
		mirror.setEndCurvePoint(c2.x, -c2.y);
		return mirror;
	}

	public float getHeight()
	{
		return height;
	}

	public float getWidth()
	{
		return endX - startX;
	}

	/**
	 * Returns true if the autoMirror flag is set, indicating that the Ring should automatically draw a mirror of
	 * itself when draw is called.
	 * @return true if the autoMirror flag is set, indicating that the Ring should automatically draw a mirror of
	 * itself when draw is called.
	 */
	public boolean isAutoMirror()
	{
		return autoMirror;
	}

	public void setAutoMirror(boolean autoMirror)
	{
		this.autoMirror = autoMirror;
	}
}

