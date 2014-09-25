/*  Author: Tyler Despatie
    Lab: 2
    Mouse Events
*/

void setup() {
    Mouse.screenSize(1600,900);
    delay(2000);
    moveWorkspace();
    openFirefox();
    drawSquare();
    drawCircle();
}

void cleanUpKeys() {
    Keyboard.set_modifier(0);
    Keyboard.set_key1(0);
    Keyboard.send_now();
}

void moveWorkspace() {
    Keyboard.set_modifier(MODIFIERKEY_GUI);
    Keyboard.set_key1(KEY_8);
    Keyboard.send_now();
    cleanUpKeys();
    delay(2000);
}

void openFirefox() {
    Keyboard.set_modifier(MODIFIERKEY_GUI | MODIFIERKEY_SHIFT);
    Keyboard.set_key1(KEY_P);
    Keyboard.send_now();
    cleanUpKeys();
    delay(10000);
}

void drawSquare() {
   delay(1000);
   Mouse.set_buttons(1, 0, 0);
   Mouse.move(0,70);
   delay(100);
   Mouse.move(70,0);
   delay(200);
   Mouse.move(0,-50);
   delay(300);
   Mouse.move(-75,0);
   delay(100);
   Mouse.set_buttons(0, 0, 0);
}
void drawCircle() {
  delay(200);
  Mouse.move(127,0);
  delay(1000);
  Mouse.set_buttons(1, 0, 0);
  float theta = 0;  // angle that will be increased each loop
  float stp = 0.1;  // amount to add to theta each time (degrees)
  int h,k,x,y;      // y coordinate of circle center
  int r = 10;
  while (theta <= 6.28) {
    x = (h + r*cos(theta));
    y = (k + r*sin(theta));
    Mouse.move(x,y);
    theta += stp;
    delay(100);
  }
  Mouse.set_buttons(0, 0, 0);
}
void loop() {
    delay(20000);
}
