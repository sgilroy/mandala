import main.*;
import processing.pdf.*;// import statements

Recorder recorder; //handles the recording functions (press r to save your design)

Ring ring1; 
Ring ring2; 
Ring ring3; 

void setup(){
  size(287,287,P3D); //set the size of the drawing area
  recorder = new Recorder(this);//intialize the recorder
  
  //code for controlling rings
  ring1 = new Ring(); // initialize ring;  
  ring2 = new Ring(); // initialize ring;  
  
//  ring1.setNumber(10);
//  ring2.setNumber(10);
  
//  ring1.setAutoMirror(true);
//  ring2.setAutoMirror(true);
  
  ring1.setCenterOffset(20);
  ring2.setCenterOffset(20);
  
  ring1.setStartPoint(0, 15);
  ring2.setStartPoint(0, -15);

  ring1.setHeight(180);
  ring2.setHeight(180);
  ring1.setStartCurvePoint(40, 60);
  ring2.setStartCurvePoint(40, 40);
  ring1.setEndCurvePoint(80, -30);
  ring2.setEndCurvePoint(80, -35);
  
  ring3 = ring2.mirror().mirror();
  ring3.setEndPoint(50, 0);
  
//  ring1.setStrokeWeight(3);
//  ring2.setStrokeWeight(6);
//  ring3.setStrokeWeight(9);
}

void draw(){
  ring1.draw(this); //draws the ring
  stroke(204, 102, 0);
  ring2.draw(this); //draws the ring
//  ring3.draw(this); //draws the ring
}
