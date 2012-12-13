package main;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Recorder {
	private PApplet parent;
	private boolean record;
	private boolean preWent;
	private float width = 287;
	
	public Recorder(PApplet parent){
		this.parent = parent;
		record = false;
		preWent = false;
		parent.registerPre(this);
		parent.registerPost(this);
		parent.registerMethod("keyEvent", this);
//		parent.registerMethod("size", this);
//    	Class<?> methodArgs[] = new Class[] { Integer.TYPE, Integer.TYPE };
//		parent.registerWithArgs(sizeMethods, "size", o, methodArgs);
	}

	public void size(int width, int height) {
		this.width = width;
	}
	
	public void pre(){
	if(!record){	
		  parent.strokeWeight(1);
		  parent.stroke(0,100,255);
		  for(int i=0;i<4;i++){
		     parent.line( width/4*i, width, width/4*i, width-30); 
		     parent.line( width, width/4*i, width-30, width/4*i);
		    
		  }
		  
		  for(int i=0;i<5;i++){
		     parent.line( width/4*i+(( width/4)/2), width, width/4*i+(( width/4)/2), width-10); 
		    parent.line( width, width/4*i+(( width/4)/2), width-10,width/4*i+(( width/4)/2));
		  }
	}
		  
		  if (record) {
		    parent.beginRaw(parent.PDF, "output.pdf");
		    //parent.println("begin record");
		    preWent = true;
		  }
	}
	
	public void post(){
		
		if (record && preWent) {
		    parent.endRaw();
		    record = false;
		    preWent = false;
		   // parent.println("end record");
		  }
	}
	
	
	public void keyEvent(KeyEvent event){
		//parent.println(event.getKeyChar());
		
		if (event.getKey() == 'r') {
		    record = true;
		    
		  //  parent.println("recorded");
		 }
		 
		
	}
	
}
