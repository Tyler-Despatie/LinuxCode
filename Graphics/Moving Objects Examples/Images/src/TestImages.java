import processing.core.PApplet;
import processing.core.PImage;


public class TestImages extends PApplet{

	
	PImage img, maskImg;	

	public void setup() {
	  size(1280,840);
	  // Make a new instance of a PImage by loading an image file
	  img = loadImage("helmet-camera.jpg");
	  maskImg = loadImage ("mask2.bmp");
	  
	}

	public void draw() {
	  background(0, 0, 0 );
	  // Draw the image to the screen at coordinate (0,0)
	  
	  for(int i = 0; i < maskImg.height-1; i++)
	  {
		  for(int j = 0; j < maskImg.width; j++)
			  maskImg.pixels[i*maskImg.width + j] = maskImg.pixels[(1+i)*maskImg.width + j];
	  }
	  
	  
	  img.mask(maskImg);
	  image(img,0, 0);
	}
	public static void main(String [] args)
	{
		PApplet.main(TestImages.class.getName());
	}
}
