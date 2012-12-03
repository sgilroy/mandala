import main.*;
import processing.pdf.*;// import statements

Recorder recorder; //handles the recording functions (press r to save your design)

Ring ring1; // ring objects
Ring ring2;


void setup(){
  size(287,287,P3D); //set the size of the drawing area
  recorder = new Recorder(this);//intialize the recorder
  
  
  
  //code for controlling rings
  ring1 = new Ring(); // initialize ring;
  
  /* Each ring has a default set of parameters which you can set individually with the following methods*/
  ring1.setNumber(10); //sets the number of objects in the ring
  ring1.setWidth(100); //sets the width of each object in the ring
  ring1.setHeight(150); //sets the height of the curves of the ring
  ring1.setCenterOffset(20); //sets the offset from the center 
  ring1.setRotationOffset(20); //offsets the rotation of the ring
  ring1.setStrokeWeight(5); //sets the weight of the stroke for drawing the ring
  ring1.flipStart(); //flips the start control point of the ring curve
  ring1.flipEnd(); //flips the end control point of the ring curve
 
 /* you can also specify all of these methods in one go with the set() method: 
   set(int num, float width, float height, float centerOffset, float rotationOffset, float strokeWeight, boolean flip1, boolean flip2)
   */
   
  ring2 = ring1.mirror(); //returns a mirrored version of a ring
  
  
}

void draw(){

 ring1.draw(this); //draws the ring
 ring2.draw(this); 

}


