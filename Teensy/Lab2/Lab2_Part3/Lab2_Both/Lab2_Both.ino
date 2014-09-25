/* Author: Tyler Despatie
   Lab: 2
   Keyboard and Mouse Events
*/

void setup() {
  Serial.begin(9600);
  delay(2000);
  changeWorkspace();
  openMatrix();
}

void cleanUpKeys() {
  Keyboard.set_modifier(0);
  Keyboard.set_key1(0);
  Keyboard.send_now();
}

void changeWorkspace() {
  //Moving Workspace
  Keyboard.set_modifier(MODIFIERKEY_GUI);
  Keyboard.set_key1(KEY_7);
  Keyboard.send_now();
  cleanUpKeys();
  delay(1000);
}

void openMatrix() {
  Keyboard.set_modifier(MODIFIERKEY_GUI);
  Keyboard.set_key1(KEY_ENTER);
  Keyboard.send_now();
  cleanUpKeys();
  delay(1000);
  Keyboard.print("cmatrix");
  Keyboard.set_key1(KEY_ENTER);
  Keyboard.send_now();
  delay(100);
  Keyboard.set_modifier(MODIFIERKEY_GUI);
  Keyboard.set_key1(KEY_F);
  Keyboard.send_now();
  cleanUpKeys();
  
}
void loop() {
  delay(5000);
}
