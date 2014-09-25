int numSoldiers = 6;
int numPlatoons = 4;
int xCoord[] = { 150, 450, 150, 450 };
int yCoord[] = { 150, 150, 450, 450 }; 
Soldier[][] s = new Soldier[numPlatoons][numSoldiers];

void setup() {
  size(600,600);
  for (int pNum=0;pNum<numPlatoons;pNum++) {
    int i2 = 0;
    for (int i=-80;i<=80;i+=80) {
      s[pNum][i2++] = new Soldier(i,40);
      s[pNum][i2++] = new Soldier(i,-40);  
    }
  }
}
void draw() {
  background(255);
  for (int pNum=0;pNum<numPlatoons;pNum++) {
    pushMatrix();
    translate(xCoord[pNum], yCoord[pNum]);
    for (int i=0;i<numSoldiers;i++) {
      if(pNum == 0 && i == 3) {
        pushMatrix();
        translate(s[pNum][i].xpos,s[pNum][i].ypos);
        rotate(radians(95));
        s[pNum][i].display(s[pNum][i].xpos,s[pNum][i].ypos);
        popMatrix();
      } else
      s[pNum][i].display(0,0);   
    }
    popMatrix();
  }
}

class Soldier {
  color c;
  int xpos, ypos, iwidth=50, iheight=70;
  
  Soldier(int xpos, int ypos) {
    c = color(200);
    this.xpos = xpos;
    this.ypos = ypos;
  }
  
  void display(int xOffset, int yOffset) {
    fill(c);
    ellipseMode(CENTER);
    ellipse((xpos - xOffset), (ypos - yOffset), iwidth, iheight);
  }
}
