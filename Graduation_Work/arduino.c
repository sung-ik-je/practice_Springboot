//Arduino 

// 비접촉 온도센서
#include <Wire.h>
#include <Adafruit_MLX90614.h>

#include <SoftwareSerial.h>

//2SoftwareSerial bt_serial(2,3);

Adafruit_MLX90614 mlx = Adafruit_MLX90614();

// mblock 통신
#include "OfflineBroadcast.h" 

#include <Arduino.h>
#include <Wire.h>
#include <SoftwareSerial.h>

float _EC_B2_B4_EC_98_A8 = 0;
float _EC_9D_B8_EC_8B_9D_EA_B2_B0_EA_B3_BC = 0;

OfflineBroadcast broadcaster; 


Servo servo_8;

void setup()
{
  Serial.begin(115200);
  mlx.begin();
  broadcaster.on(String("OPENDOOR"),broadcastHandler);
  servo_8.attach(8);
  broadcaster.broadcast(String("message"),String("1"));
  broadcaster.on(String("OPENDOOR"),broadcastHandler);
}

void _loop()
{
  broadcaster.loop();
}

void loop()
{
  if ( digitalRead(7) == LOW ) // 손이 감지 되었을 경우
  {
    delay(1000);
    float temp = mlx.readObjectTempC()+0.0; // 온도 보정 0도
    int int_temp = temp*10;
    broadcaster.broadcast(String("message"), String(temp));
    delay(2000);
  }
  _loop();
}

void broadcastHandler()
{
  for(int count=0;count<1;count++){
      servo_8.write(90);
      _delay(3);
      servo_8.write(0);
  }

  broadcaster.callOK();
}

void _delay(float seconds) {
  long endTime = millis() + seconds * 1000;
  while(millis() < endTime) _loop();
}