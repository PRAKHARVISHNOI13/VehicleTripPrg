Assumptions –

1-	It has been assumed, that data will be in sync ie there is no such case where STOP for a CAR come earlier then START of CAR
2-	Application has been designed for 4 cars .
3-	There no incomplete or unknown command, if there is, it will be taken as NONE.
4-	Reading instruction file from C:\test\filename.txt . Placed a sample in "com.vehicle" package.

API output –

           http://localhost:8085/VehicleTripApp/vehicleInfo/{vehicleNo}

            for eg- http://localhost:8085/VehicleTripApp/vehicleInfo/2

for All also there has been another API

               http://localhost:8085/VehicleTripApp/vehicleInfo/all

Output format –

                 {"vehicleId":2,"tripNo":1,"tripDuration":110}

Trip duration is in Milliseconds.






Architecture –

Application has been made on Spring boot and as instructed in-memory database HSSQLDB.


File ----------------> Writer ---> In Memory Queue --- >  Reader----> In memory Database
(C:\test\filename.txt)


API Call --->

Controller ---- > Service ----- > Dao


How to Run-



If import the project in – (eclipse ide)

Build Project by - mvn clean install ( While Build One can see Unit test Result)
Run it by – class –
com.vehicle.VehicleTripApplication

Right click – Run as java Application


Test Cases -
1-API testing - with help of Mockito
2- Database testing 
