int redPin =  21;
int greenPin =  23;
int bluePin =  22;
int pButton = 12;

int led[3] = { redPin, greenPin, bluePin };
int iCount = 0;
int iPaused = 0;

void setup()   
{                
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
  pinMode(pButton, INPUT);
}

void loop() {
  analogWrite(led[0], 150);
  analogWrite(led[1], 0);
  analogWrite(led[2], 0); 
  delay(400);
  
  if (digitalRead(pButton) == LOW)
    if (iCount++ > 1) {
      int randomNum = random(1,3);
      for (int i=0; i<randomNum;i++) {
        int temp = led[0];
        for(int i =0; i<2; i++) 
          led[i] = led[i+1];
        led[2] = temp;
      }
    } else
      iPaused = 1;
    
  if(iPaused == 0) {
    int temp = led[0];
    for(int i =0; i<2; i++) 
      led[i] = led[i+1];
    led[2] = temp;
  }   
}

   
