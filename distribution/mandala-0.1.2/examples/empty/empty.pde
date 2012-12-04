
import main.*;
import processing.pdf.*;// import statements

Recorder recorder; //handles the recording functions (press r to save your design)

Ring ring1; 

void setup(){
  size(287,287,P3D); //set the size of the drawing area
  recorder = new Recorder(this);//intialize the recorder
  
  
  
  //code for controlling rings
  ring1 = new Ring(); // initialize ring;
  
  
  
}

void draw(){

 ring1.draw(this); //draws the ring

}


