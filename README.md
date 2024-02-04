# Wi-Fi Router Simulation 

## Overview 
This is a Java project that simulates a Wi-Fi router using threading and semaphores to limit the number of concurrent connections. The program includes classes for Router, Semaphore, Device, and Network, each serving a specific purpose in the simulation.

## Project Structure
• Router Class: Contains a list of connections and methods to occupy a connection and release a connection.

• Semaphore Class: Implementation of a semaphore, as explained in the synchronization lab.

• Device Class: Represents different devices (threads) that can be connected to the router. Each device has a name and type, and it can perform three activities: connect, perform online activity, and disconnect/logout.

• Network Class: Contains the main method where the user is prompted for inputs such as the maximum number of connections a router can accept (N) and the total number of devices wishing to connect (TC).

### Sample Input
What is the number of WI-FI Connections?
2
What is the number of devices Clients want to connect?
4
C1 mobile
C2 tablet
C3 pc
C4 pc
### Sample Output
```java 
- (C1)(mobile)arrived
- (C2)(tablet)arrived
- Connection 1: C1 Occupied
- Connection 2: C2 Occupied
- C4(pc) arrived and waiting
- C3(pc)arrived and waiting
- Connection 1: C1 login
- Connection 1: C1 performs online activity
- Connection 2: C2 login
- Connection 2: C2 performs online activity
- Connection 1: C1 Logged out
- Connection 1: C4 Occupied
- Connection 1: C4 log in
- Connection 1: C4 performs online activity
- Connection 2: C2 Logged out
- Connection 2: C3 Occupied

## Dependencies 
This CLI project is implemented in Java and does not require any external dependencies beyond the standard Java libraries.

## Contributing
Contributions to this project are welcome. Feel free to fork the repository and create pull requests for improvements or additional features.

## Contributers
This project is developed by the following team members:
- [Hend Ahmad](https://github.com/LifelongLearner-HEND)
- [Youssef Morad](https://github.com/YoussefMorad1)
- [Farah Mohammad](https://github.com/farah2543)
- [Marawan Ahmad](https://github.com/maro312)
