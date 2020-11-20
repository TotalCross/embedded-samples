/*  COMANDOS
    * FINALIZAR INSTRUÇÃO 
    , SEPARATOR 
    # SET MODE = #8,0* = PIN 8 INPUT MODE
    < SET VALUE DIGITAL = <1,0* = SET PIN 1 LOW
    > GET VALUE DIGITAL= >13*  = GET VALUE PIN 13
    + SET VALUE PWM = +6,250* = SET PIN 6 VALUE 250    
    - GET VALUE ANALOGICO = -14* = GET VALUE PIN A0
    
#2,1*#3,1*#4,1*
<2,1*<3,1*<4,1*
>2,1*>3,1*>4,1*
*/

void setup() {
  Serial.begin(115200); 
  Serial.println("Conectado");
  Serial.println("Esperando comando...");  
}

void loop() {

String text="";
char character;
String pin="";
String value="0";
char separator='.';
char inst='.';
  while(Serial.available()){ // verifica se RX esta recebendo dados
    delay(10);
    character= Serial.read();
    if(character=='*'){
      action(inst,pin,value);
      break;
     }
     else
      text.concat(character);
      
    if(character==',')
      separator=character;
      
    if(inst=='.')
      inst = character;
    else if(separator!=',' && character!=inst )
      pin.concat(character);
    else if (character!=separator && character!=inst )
      value.concat(character); 
  }

}

void action(char instruction, String pin, String value){

  if (instruction=='#'){//pinMode
    pinMode(pin.toInt(),value.toInt());
  }
  if (instruction=='<'){//digitalWrite
    digitalWrite(pin.toInt(),value.toInt());
  }
  if (instruction=='>'){ //digitalRead
    String aux= pin+':'+String(digitalRead(pin.toInt()));
    Serial.println(aux);
  }
  if (instruction=='+'){ // analogWrite = PWM
    analogWrite(pin.toInt(),value.toInt());
  }
  if (instruction=='-'){ // analogRead
    String aux= pin+':'+String(analogRead(pin.toInt()));
    Serial.println(aux);
  }
  }
