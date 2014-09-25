/* Author: Tyler Despatie
   Lab: 2
   Keyboard and Mouse Events
   
*/

void setup() {
  Serial.begin(9600);
  delay(2000);
  openNotepad();
}

void cleanUpKeys() {
  Keyboard.set_modifier(0);
  Keyboard.set_key1(0);
  Keyboard.send_now();
}

void openNotepad() {
  //Moving Workspace
  Keyboard.set_modifier(MODIFIERKEY_GUI);
  Keyboard.send_now();
  Keyboard.set_key1(KEY_9);
  Keyboard.send_now();
  //Release
  cleanUpKeys();
  delay(1000);
  
  //Open dMenu
  Keyboard.set_modifier(MODIFIERKEY_GUI);
  Keyboard.send_now();
  Keyboard.set_key1(KEY_D);
  Keyboard.send_now();
  //Release
  cleanUpKeys();
  delay(1000);
  
  //Open Leafpad
  Keyboard.print("leafpad");
  Keyboard.set_key1(KEY_ENTER);
  Keyboard.send_now();
  //Release
  cleanUpKeys();
  delay(2000);
  
  //Type into Leafpad
  Keyboard.print("Hello World");
  Keyboard.set_modifier(MODIFIERKEY_CTRL);
  Keyboard.set_key1(KEY_S);
  Keyboard.send_now();
  cleanUpKeys();
  delay(2000);
  
  Keyboard.print("Random.txt");
  delay(100);
  Keyboard.set_key1(KEY_DOWN);
  Keyboard.send_now();
  delay(100);
  Keyboard.set_key1(KEY_ENTER);
  Keyboard.send_now();
  cleanUpKeys();
  delay(2000);
}

void loop() { 
  //Type into Leafpad
  Keyboard.print("Hello World");
  Keyboard.set_modifier(MODIFIERKEY_CTRL);
  Keyboard.set_key1(KEY_S);
  Keyboard.send_now();
  cleanUpKeys();
  delay(30000);
}
