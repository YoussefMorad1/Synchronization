import java.util.Scanner;

class Network {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the maximum number of connections a router can accept
        System.out.println("What is the number of connections can the router can accept  ");
        int maxConnections = scanner.nextInt();

        // Get the total number of devices that wish to connect
        System.out.println("What is the number of devices Clients want to connect? ");
        int totalDevices = scanner.nextInt();

        // Create a router with the specified maximum connections
        Router router = new Router(maxConnections);

        // Create an array to store devices
        Device[] devices = new Device[totalDevices];

        // Get device information and create device objects
        for (int i = 0; i < totalDevices; i++) {
            System.out.println("Enter the name and type of device " + (i + 1) + ":");
            String name = scanner.next();
            String type = scanner.next();
            devices[i] = new Device(name, type, router);
        }

        // Redirect output to a text file
        File outputFile = new File("output.txt");
        try {
            PrintStream fileStream = new PrintStream(outputFile);
            System.setOut(fileStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Start threads for each device
        for (Device device : devices) {
            device.start();
        }
        //This ensures that the main thread doesn't exit until all the device threads have finished executing.
        for (Device device : devices) {
            //join() method can throw this exception if the thread is interrupted while waiting for the device thread to finish
            try {
                device.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
