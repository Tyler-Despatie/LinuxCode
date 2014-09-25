int numSoldiers = 6;
int platoonSize = 6;
int sWidth = 50;
int sHeight = 50;
int spaceX = 0;
int spaceY = 120;
int numPlatoons = 4;

Soldier[][] s = new Soldier[numPlatoons][numSoldiers];
void setup() {
  size(1000,800);
  for (int pNum=0;pNum<numPlatoons;pNum++) {
    int i2 = 0;
    for (int i=100;i2<platoonSize;i=i+40)
      if(i2 % 2 == 0)
        s[pNum][i2++] = new Soldier(i+spaceX,spaceY-70,sWidth,sHeight);
      else
        s[pNum][i2++] = new Soldier((i-40)+spaceX,spaceY,sWidth,sHeight);
     
     if (pNum % 2 != 0) {
       spaceX = 0;
       spaceY += 120;
     } else 
       spaceX += 180;
  } 
}

void draw() {
  background(255);
  
  for (int pNum=0;pNum<numPlatoons;pNum++) {
    pushMatrix();
    translate(s[pNum][0].xpos, s[pNum][0].ypos);
    point(0,0);
    //rotate(radians(30));
    scale(1);
  
    for(int i=0;i<numSoldiers;i++)   
      s[pNum][i].display(); 
    popMatrix();
  }
  
}

class Soldier {
  color c;
  int xpos, ypos, iwidth, iheight;
  
  Soldier(int xpos, int ypos, int iwidth, int iheight) {
    c = color(200);
    this.xpos = xpos;
    this.ypos = ypos;
    this.iwidth = iwidth;
    this.iheight = iheight;
  }
  
  void display() {
    fill(c);
    ellipseMode(CENTER);
    ellipse(xpos, ypos, iwidth, iheight);
  }
}

