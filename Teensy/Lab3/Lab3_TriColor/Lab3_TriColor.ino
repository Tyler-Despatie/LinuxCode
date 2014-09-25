int redPin =  21;
int greenPin =  23;
int bluePin =  22;
int currentIntensity = 0;
int led[3] = { redPin, greenPin, bluePin };

void setup()   
{                
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
}

void loop()                     
{
  // set all 3 pins to the desired intensity
  analogWrite(led[0], currentIntensity);
  analogWrite(led[1], 255 - currentIntensity);
  analogWrite(led[2], 0);
  
  // remain at this color, but not for very long
  delay(20);
  
  // increase the red
  currentIntensity = currentIntensity + 1;
  
  // since 255 is the maximum, set it back to 0
  // when it increments beyond 255
  if (currentIntensity > 255) {
    currentIntensity = 0;
    //Shift link list style
    int temp = led[0];
    for(int i =0; i<2; i++) 
      led[i] = led[i+1];
    led[2] = temp;
  }   
}

