/*
  Author: Tyler Despatie
  Lab: 2
  Student Number: 040-694-672
  Course: CST8236 - Computer Graphics
  Date Due: Tuesday, September 16, 2014
*/
//Globals
float bChange = 1.2;
float bAngle = 1;
int bLimit = 40;

void setup() {
  size(400,300);
  fill(0,0,255);
}
void draw() {
  background(255);
  bAngle += bChange;
  if (bAngle > bLimit || bAngle < -bLimit) {
    bChange = -bChange;
    bAngle += bChange;
  }
  pushMatrix();
  translate(width/2, height - 65);
  drawBody();
  drawNeck();
  drawHead();
  translate(-4, -90);
  drawRightArm();
  drawRightForeArm();
  translate(8,0);  
  drawLeftArm();
  drawLeftForeArm();
  popMatrix();
  
}
void drawBody() {
  rectMode(CENTER);
  rotate(radians(bAngle));
  rect(0,0,30,140);
}
void drawNeck() {
  pushMatrix();
  translate(0,-85);
  rotate(radians(-bAngle)/1.57); //Limit the swing
  rect(0,0,10,30);
  popMatrix();
  rectMode(CORNER);
}
void drawHead() {
  pushMatrix();
  translate(0,-120);
  rotate(radians(bAngle)/2); //Limit the swing
  ellipse(0,0,40,40);
  popMatrix();
}
void drawRightArm() {
  pushMatrix();
  translate(20,20);
  rotate(radians(bAngle));
  rect(0,0,80,15);
}
void drawRightForeArm() {
  translate(80,0);
  rotate(radians(-bAngle)*1.57); //Add to the swing
  rect(0,0,80,15);
  popMatrix();
}
void drawLeftArm() {
  pushMatrix();
  translate(-20,20);
  rotate(radians(bAngle+90)); //Make a reflection of the right arm
  rect(0,0,15,80);
}
void drawLeftForeArm() {
  translate(0,80);
  rotate(radians(-bAngle)*1.57); //Add to the swing
  rect(0,0,15,80);
  popMatrix();
}
