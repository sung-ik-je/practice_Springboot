//offlinebroadcast1
#include "OfflineBroadcast.h"
unsigned char prevc;
byte index = 0;
byte dataLen;
bool isAvailable,isStart;
uint8_t command_index = 0;
char serialRead;
char buffer[52];
#define MAX_LISTENER 10

struct Listener
{
    String msg;
    void (*callback)(void);
};
struct Listener listenList[20];
int listenerP=0;
OfflineBroadcast::OfflineBroadcast(void)
{}
void OfflineBroadcast::readSerial(){
  isAvailable = false;
  if(Serial.available()>0){
    isAvailable = true;
    serialRead = Serial.read();
  }
}
unsigned char OfflineBroadcast::readBuffer(int index){
 return buffer[index]; 
}

void OfflineBroadcast::loop()
{
	readSerial();
  if(isAvailable){
	unsigned char c = serialRead&0xff;
	if(c==0x55&&isStart==false){
	 if(prevc==0xff){
	  index=1;
	  isStart = true;
	 }
	}else{
	  prevc = c;
	  if(isStart){
		if(index==2){
		 dataLen = c; 
		}else if(index>2){
		  dataLen--;
		}
		writeBuffer(index,c);
	  }
	}
	 index++;
	 if(index>51){
	  index=0; 
	  isStart=false;
	 }
	 if(isStart&&dataLen==0&&index>3){ 
		isStart = false;
		parseData(); 
              index=0;
	  }
      }
    }
void OfflineBroadcast::broadcast( String msg){
  uint8_t arr[50]={0,0,1,0x46,1,1};
  int len = msg.length();
  int size = 6;
  if(len==0){
    return;
  }
  arr[5] = len;
	for(int i=0;i<len;i++){
    	arr[size] = uint8_t(msg[i]);
    	size++;
  }

 arr[0] = size-1;
  writeHead();
  for(int i=0;i<size;i++)
  {
    writeSerial(arr[i]);
  }
  writeEnd();
  delay(100);
}
void OfflineBroadcast::broadcast(String msg,String value){
  uint8_t arr[50]={0,0,1,0x46,2,1};
  int len = msg.length();
  if(len==0){
    return;
  }
  int len2 = value.length();
  int size = 6;
  arr[5] = len;
  for(int i=0;i<len;i++){
      arr[size] = uint8_t(msg[i]);
      size++;
  }
  arr[size++] = len2;
  for(int i=0;i<len2;i++){
      arr[size++] = uint8_t(value[i]);
  }
  arr[0] = size-1;
  writeHead();
  for(int i=0;i<size;i++)
  {
    writeSerial(arr[i]);
  }
  writeEnd();
  delay(100);
}

void OfflineBroadcast::readSensor(int device){
   /**************************************************
      ff    55      len idx action device type len name  
      0     1       2   3   4      5      6    7    8
      0xff  0x55   0x4 0x3 0x1    0x46    0x1  0x2  48 69
      -----------------------------------------------
      ff    55      len idx action device type len name len message
      0   1   2 3 4   5   6 7 8 9 10
  ***************************************************/
 int type;
  switch(device){
    case  BROADCAST:{
      type = readBuffer(6);
      
      if(type==1){
        int len = readBuffer(7);
        broadcastMsg = readString(8,len); 
        broadcastValue = "";
      }
      
      else if(type==2){
        int nlen = readBuffer(7);
        broadcastMsg = readString(8,nlen);
        int vlen = readBuffer(7+nlen+1);
        broadcastValue = readString(7+nlen+2,vlen);
      }
      bool hasCallback = false;
      for(int i=0;i<MAX_LISTENER;i++){
        if(broadcastMsg.equals(listenList[i].msg)){
          listenList[i].callback();
          hasCallback = true;
        }
      } 
      if(!hasCallback){
        callOK();
      }
    }
    break;
  }
}
void OfflineBroadcast::parseData(){
  isStart = false;
  int idx = readBuffer(3);
  command_index = (uint8_t)idx;
  int action = readBuffer(4);
  int device = readBuffer(5);
  switch(action){
    case GET:{
        readSensor(device);
     }
     break;
  }
}

void OfflineBroadcast::writeBuffer(int index,unsigned char c){
  buffer[index]=c;
}
void OfflineBroadcast::writeHead(){
  writeSerial(0xff);
  writeSerial(0x55);
}
void OfflineBroadcast::writeEnd(){
 Serial.println(); 
}
void OfflineBroadcast::writeSerial(unsigned char c){
 Serial.write(c);
}
char _receiveStr[20] = {};
uint8_t _receiveUint8[16] = {};
String OfflineBroadcast::readString(int idx,int len){
  char p[50];
  for(int i=0;i<len;i++){
    p[i]=readBuffer(idx+i);
  }
  p[len] = '\0';
  return String(p);
}
void OfflineBroadcast::callOK(){
    uint8_t arr[5]={4,0,1,0x46,3};
    writeHead();
    for(int i=0;i<5;i++)
    {
      writeSerial(arr[i]);
    }
    writeEnd();
}
void OfflineBroadcast::on(String msg,void(*callback)(void)){
  struct Listener listener;
  listener.msg = msg;
  listener.callback = callback;
  if(listenerP<MAX_LISTENER){
    listenList[listenerP++] = listener;
  }
}

#ifndef OfflineBoardcast_H
#define OfflineBoardcast_H
#include "MeSerial.h"
#include <Arduino.h>

#define BROADCAST 70
#define GET 1

class OfflineBroadcast
{
public:
	OfflineBroadcast(void);
	void loop();
	String broadcastMsg = "";
	String broadcastValue = "";
	void broadcast(String msg,String value);
  void broadcast(String msg);
  void callOK();
  void on(String msg,void(*callback)(void));
private:
  void readSensor(int device);
  unsigned char readBuffer(int index);
  void writeBuffer(int index,unsigned char c);
  void parseData();
  void writeEnd();
  void writeSerial(unsigned char c);
  void readSerial();
  String readString(int idx,int len);
  void writeHead();
};
#endif