# WellBiing-Healthcare---IoT-based

## Overview
The solution consists of a hardware prototype that collects sensor data of
an individual based on the following parameters - blood oxygen, pulse rate, body
temperature and RFID. The prototype then sends the data to an IoT Cloud using a
Wi-Fi module, for dashboarding and storage. The data is then displayed on the
dashboard in a Java Application implemented using OOP to the stakeholders in this
case, the patients and the doctor. Additionally, the Doctor can add records to the 
IoT cloud directly from the Java application if required.

## Hardware Interface
The sensor data with the health parameters- Heart rate, Blood oxygen, and
Temperature along with the RFID identity would be sent to the NodeMCU
ESP8266 12E and subsequently communicated to the IoT Cloud using its onboard
Wi-Fi module. In the cloud, data is stored, analyzed and then visualized using
charts on the dashboard on ThingSpeak.

## Screenshots of the Java GUI Application
![image](https://user-images.githubusercontent.com/105193713/229857234-dd7cd2c8-67d4-4995-b454-fc7eb1142fdf.png)
Patient Dashboard

![image](https://user-images.githubusercontent.com/105193713/229857389-89595732-175d-4b4c-baf9-cf5fe3757558.png)
Doctor Dashboard

![image](https://user-images.githubusercontent.com/105193713/229857435-3d996c21-2921-4339-9bac-2d82f84c9fee.png)
Manual Data Entry Page for Health Parameters

