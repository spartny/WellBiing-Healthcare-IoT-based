//NodeMCU ESP8266 and Thingspeak initialization
#include <ESP8266WiFi.h>
#include "ThingSpeak.h"
const char* ssid = "Arnav's Android"; // your network SSID (name)
const char* password = "abcde123"; // your network password
WiFiClient client;
unsigned long myChannelNumber = 1898562;
const char * myWriteAPIKey = "G71SDBACFUCGUBCM";
//RFID initialization
#include <SPI.h>
#include <MFRC522.h>
constexpr uint8_t RST_PIN = D3;
constexpr uint8_t SS_PIN = D4;
MFRC522 mfrc522(SS_PIN, RST_PIN); // Create MFRC522 instance
MFRC522::MIFARE_Key key;
String uid;
int user = 0;
//MAX30102 initialization
#include <Wire.h>
#include "MAX30105.h"
#include "spo2_algorithm.h"
float temperatureF = 0.0;
MAX30105 particleSensor;
#define MAX_BRIGHTNESS 255
uint32_t irBuffer[100]; //infrared LED sensor data
uint32_t redBuffer[100]; //red LED sensor data
int32_t bufferLength; //data length
int32_t spo2; //SPO2 value
int8_t validSPO2; //indicator to show if the SPO2 calculation is valid
int32_t heartRate; //heart rate value
int8_t validHeartRate; //indicator to show if the heart rate calculation
is valid
void setup() {
Serial.begin(115200); //Initialize serial
WiFi.mode(WIFI_STA);
ThingSpeak.begin(client); // Initialize ThingSpeak
//WiFi connection
if(WiFi.status() != WL_CONNECTED){
Serial.println("Attempting to connect");
while(WiFi.status() != WL_CONNECTED){
WiFi.begin(ssid, password);
delay(5000);
}
Serial.println("\nConnected.");
}
}
void loop(){
setup_rfid();
}
void sendToCloud() {
// Write to ThingSpeak. There are up to 8 fields in a channel, allowing
you to store up to 8 different
// pieces of information in a channel. Here, we write to field 1.
int x = ThingSpeak.writeFields(myChannelNumber, myWriteAPIKey);
if(x == 200){
Serial.println("");
Serial.println("Channel update successful.");
delay(1000);
}
else{
Serial.println("Problem updating channel. HTTP error code " +
String(x));
}
}
void setup_rfid(){
SPI.begin(); // Init SPI bus
mfrc522.PCD_Init(); // Init MFRC522
delay(4); // Optional delay.
Serial.println(F("Show Identification!"));
delay(2000);
rfid();
}
//method to initiate the RFID reading on prototype
void rfid() {
delay(3000);
// Reset the loop if no new card present on the sensor/reader. This
saves the entire process when idle.
if ( ! mfrc522.PICC_IsNewCardPresent())
return;
// Verify if the NUID has been readed
if ( ! mfrc522.PICC_ReadCardSerial())
return;
uid ="";
for (byte i = 0; i < mfrc522.uid.size; i++) {
uid += (mfrc522.uid.uidByte[i]);
}
Serial.println("");
//user is verified as 1 and 2 based on uid
if(uid == "109216161213"){
user = 1;
}
if (uid == "85187208101"){
user = 2;
}
Serial.print(F("Hi, "));
Serial.print("User" + String(user));
ThingSpeak.setField(1, (int) user);
delay(3000);
setup_tempSense();
}
//setup temperature
void setup_tempSense(){
// Initialize sensor
if (particleSensor.begin(Wire, I2C_SPEED_FAST) == false) //Use default
I2C port, 400kHz speed
{
Serial.println(F("MAX30102 was not found. Please check wiring/power.
"));
while (1);
}
//The LEDs are very low power and won't affect the temp reading much but
//you may want to turn off the LEDs to avoid any local heating
particleSensor.setup(0); //Configure sensor. Turn off LEDs
//particleSensor.setup(); //Configure sensor. Use 25mA for LED drive
particleSensor.enableDIETEMPRDY(); //Enable the temp ready interrupt.
This is required.
Serial.println("");
Serial.println(F("Place your finger on sensor (30s) for temperature
collection! "));
delay(30000);
tempSense();
}
//method to initiate temperature sensing
void tempSense(){
temperatureF = particleSensor.readTemperatureF();
temperatureF = temperatureF + 5;
Serial.print(F("temp="));
Serial.print(temperatureF);
Serial.println();
ThingSpeak.setField(4, (int)temperatureF);
Serial.println(F("Temperature collected!"));
Serial.println("");
setup_hrspo2();
}
//setup HR and SpO2
void setup_hrspo2(){
// Initialize sensor
if (!particleSensor.begin(Wire, I2C_SPEED_FAST)) //Use default I2C port,
400kHz speed
{
Serial.println(F("MAX30102 was not found. Please check
wiring/power."));
while (1);
}
byte ledBrightness = 60; //Options: 0=Off to 255=50mA
byte sampleAverage = 4; //Options: 1, 2, 4, 8, 16, 32
byte ledMode = 2; //Options: 1 = Red only, 2 = Red + IR, 3 = Red + IR +
Green
byte sampleRate = 100; //Options: 50, 100, 200, 400, 800, 1000, 1600,
3200
int pulseWidth = 411; //Options: 69, 118, 215, 411
int adcRange = 4096; //Options: 2048, 4096, 8192, 16384
Serial.println("Place finger on sensor for PulseOximeter readings!");
particleSensor.setup(ledBrightness, sampleAverage, ledMode, sampleRate,
pulseWidth, adcRange); //Configure sensor with these settings
hrspo2();
}
void hrspo2(){
bufferLength = 100; //buffer length of 100 stores 4 seconds of samples
running at 25sps
//read the first 100 samples, and determine the signal range
for (byte i = 0 ; i < bufferLength ; i++)
{
while (particleSensor.available() == false) //do we have new data?
particleSensor.check(); //Check the sensor for new data
redBuffer[i] = particleSensor.getRed();
irBuffer[i] = particleSensor.getIR();
particleSensor.nextSample(); //We're finished with this sample so move
to next sample
}
//calculate heart rate and SpO2 after first 100 samples (first 4 seconds
of samples)
maxim_heart_rate_and_oxygen_saturation(irBuffer, bufferLength,
redBuffer, &spo2, &validSPO2, &heartRate, &validHeartRate);
//Continuously taking samples from MAX30102. Heart rate and SpO2 are
calculated every 1 second
while(1)
{
//dumping the first 25 sets of samples in the memory and shift the
last 75 sets of samples to the top
for (byte i = 25; i < 100; i++)
{
redBuffer[i - 25] = redBuffer[i];
irBuffer[i - 25] = irBuffer[i];
}
//take 25 sets of samples before calculating the heart rate.
for (byte i = 75; i < 100; i++)
{
while (particleSensor.available() == false) //do we have new data?
particleSensor.check(); //Check the sensor for new data
redBuffer[i] = particleSensor.getRed();
irBuffer[i] = particleSensor.getIR();
particleSensor.nextSample(); //We're finished with this sample so
move to next sample
}
if ((validSPO2 == 1) && (validHeartRate == 1) &&(heartRate > 55) &&
(spo2 > 70)){
Serial.println("");
Serial.print(F("HR="));
Serial.print(heartRate, DEC);
Serial.println("");
Serial.print(F("SPO2="));
Serial.print(spo2, DEC);
ThingSpeak.setField(2, (int)heartRate);
ThingSpeak.setField(3, (int)spo2);
sendToCloud();
break;
}
//After gathering 25 new samples recalculate HR and SP02
maxim_heart_rate_and_oxygen_saturation(irBuffer, bufferLength,
redBuffer, &spo2, &validSPO2, &heartRate, &validHeartRate);
}
}
