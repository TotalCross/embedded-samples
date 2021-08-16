# Programa : Sensor de temperatura DHT11 com Raspberry Pi

# Carrega as bibliotecas
import Adafruit_DHT
import RPi.GPIO as GPIO
 
# Define o tipo de sensor
sensor = Adafruit_DHT.DHT11
#sensor = Adafruit_DHT.DHT22
 
GPIO.setmode(GPIO.BOARD)
 
# Define a GPIO conectada ao pino de dados do sensor
pino_sensor = 25

   # while(1):
   # Efetua a leitura do sensor
umid, temp = Adafruit_DHT.read_retry(sensor, pino_sensor);

   # Caso leitura esteja ok, mostra os valores na tela
if umid is not None and temp is not None:
  print ("{0:0}".format(temp).rstrip('0').rstrip('.'));
else:
# Mensagem de erro de comunicacao com o sensor
  print("error")