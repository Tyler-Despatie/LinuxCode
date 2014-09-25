import processing.core.*;

public class ProcessingApplet extends PApplet {
    int numSoldiers = 6;
    int numPlatoons = 4;
    int globalRotation = 0;
    int xCoord[] = { 150, 450, 150, 450 };
    int yCoord[] = { 150, 150, 450, 450 }; 
    Soldier[][] s = new Soldier[numPlatoons][numSoldiers];

    public void setup() 
    {
        size(600,600);
  	    for (int pNum=0;pNum<numPlatoons;pNum++) {
    	    int i2 = 0;
    	    for (int i=-80;i<=80;i+=80) {
      	        s[pNum][i2++] = new Soldier(this, i,40);
      	        s[pNum][i2++] = new Soldier(this, i,-40);  
            }
        }
    }
    public void draw()
    {
        background(0);
  	    for (int pNum=0;pNum<numPlatoons;pNum++) {
    	    pushMatrix();
    	    translate(xCoord[pNum], yCoord[pNum]);
            rotate(radians(globalRotation));
    	    for (int i=0;i<numSoldiers;i++) {
                if(pNum == 0 && i == 3) {
                    pushMatrix();
                    translate(s[pNum][i].xpos,s[pNum][i].ypos);
                    rotate(radians(90));
                    s[pNum][i].display(s[pNum][i].xpos,s[pNum][i].ypos);
                    popMatrix();
                } else
                    s[pNum][i].display(0,0);   
            }
            popMatrix();
        }
    }
    public void setGlobalRotation(int amount) 
    {
        this.globalRotation = amount;
    }
}
class Soldier {
    PApplet parent;
    int c; 
    int xpos, ypos, iwidth=50, iheight=70;
  
    Soldier(PApplet pApplet, int xpos, int ypos) {
        this.parent = pApplet;
        c = parent.color(200,200,200); 
        this.xpos = xpos;
        this.ypos = ypos;
    }
  
    void display(int xOffset, int yOffset) {
        parent.fill(c);
        parent.ellipseMode(parent.CENTER);
        parent.ellipse((xpos - xOffset), (ypos - yOffset), iwidth, iheight);
    }
}
