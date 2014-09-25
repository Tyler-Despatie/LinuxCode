import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;



public class MovingImage extends PApplet {
PVector move, smileLocation[], smileyDirection[], gravity, magnetLocation;

public boolean[]   started = new boolean[10];
PImage smiley[], magnet;

public void setup()
{
	size(800, 800);
	smiley = new PImage[10];
	smileLocation = new PVector[10];
	smileyDirection =new PVector[10];
	magnet = loadImage("Magnet.png");
	for(int i = 0; i < smiley.length; i++)
	{
		started[i] = false;
	  smiley[i] = loadImage("smiley-face1.png");
	  smileLocation[i] = new PVector(0, 50);
	  smileyDirection[i] = new PVector(3, 0);
	}
	  gravity = new PVector(0, 0.04f);
	  started[0] = true;
	  magnetLocation = new PVector(500, 500);
}

public void resetLocations()
{
	for(int i = 0; i < smiley.length; i++)
	{
		started[i] = false;
	  smiley[i] = loadImage("smiley-face1.png");
	  smileLocation[i] = new PVector(0, 50);
	  smileyDirection[i] = new PVector(3, 0);
	}
	  gravity = new PVector(0, 0.04f);
	  started[0] = true;
}

	public void draw()
	{
		background(255);//0, 0, 0 );
		
		image(magnet, magnetLocation.x, magnetLocation.y, 50, 50);
		float force, d;
		PVector magnetForce;
		
		for(int i = 0; i < smileLocation.length; i++)
		{
			if(started[i])
			{
					smileLocation[i].add(smileyDirection[i]);
					smileyDirection[i].add(gravity);
					if((smileLocation[i].x > 800) || (smileLocation[i].x < 0))
					{
						smileyDirection[i].x *= -1;
						if(i < 9)
						{
							if(started[i+1] == false)
								started[i+1] = true;
						}
						else
						{
							resetLocations();
						}
								
					}
					
					if((smileLocation[i].y > 800))
						smileyDirection[i].y *= -1;
					
					
					smileLocation[i].add(smileyDirection[i]);
					d = (smileLocation[i].dist(magnetLocation));
					force = -1.0f/ (d*d);
			
					magnetForce = PVector.sub(magnetLocation, smileLocation[i]);
					magnetForce.setMag(5000*force);
					
					smileyDirection[i].add(magnetForce);
					
					image(smiley[i], smileLocation[i].x, smileLocation[i].y, 50, 50);
			}
		}
	}
}
