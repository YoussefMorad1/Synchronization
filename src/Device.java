class Device extends Thread {
    String name;
    String type;
    Router router;
    int connectionId;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    // Connect to the router
    public void connect() {
        router.addConnection(this); // add connection to the router
        System.out.println("- Connection " + connectionId + ": " + name + " Occupied"); // print that the device is connected
    }
    // Simulate online activity
    public void doActivity() {
        System.out.println("- Connection " + connectionId + ": " + name + " performs online activity");
    }
    // Disconnect from the router
    public void disconnect() {
        System.out.println("- Connection " + connectionId + ": " + name + " Logged out");
        router.removeConnection(this);
    }
    // Set connection id
    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }
    // Run the device thread (connect, do activity, disconnect)
    @Override
    public void run() {
        connect();
        // sleep for a random time (less than 1 second) to simulate online activity
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doActivity();
        disconnect();
    }
}
