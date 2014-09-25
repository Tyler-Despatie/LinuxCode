void setup() {
  size(500,500);
}

void draw() {
  background(150);
  
  //Line  
  stroke(0,255,0);
  line( 20, 20, 480, 480);
  line(480, 20,  20, 480);
  
  //Ellipse
  stroke(0);
  fill(50,100,200);
  ellipse(mouseX, mouseY, 80, 100);
  
  //Rectangle
  stroke(50);
  fill(255,10,10);
  rectMode(CENTER);
  rect(250, 250, 100, 100);
  
}
