# WellBiing-Healthcare---IoT-based

## Overview
The solution consists of a hardware prototype that collects sensor data of
an individual based on the following parameters - blood oxygen, pulse rate, body
temperature and RFID. The prototype then sends the data to an IoT Cloud using a
Wi-Fi module, for dashboarding and storage. The data is then displayed on the
dashboard in a Java Application implemented using OOP to the stakeholders in this
case, the patients and the doctor.

## Hardware Interface
The sensor data with the health parameters- Heart rate, Blood oxygen, and
Temperature along with the RFID identity would be sent to the NodeMCU
ESP8266 12E and subsequently communicated to the IoT Cloud using its onboard
Wi-Fi module. In the cloud, data is stored, analyzed and then visualized using
charts on the dashboard on ThingSpeak.



