public class Device extends Thread {
    String name;
    String type;
    Router router;
    int connectionId;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    public void connect() {
        // TODO: Connect to the router using router.addConnection() and print that you are connected
    }

    public void doActivity() {
        System.out.println("Connection " + connectionId + ": " + name + " performs online activity");
    }

    public void disconnect() {
        // TODO: Disconnect from the router using router.removeConnection() and print that you are disconnected
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    @Override
    public void run() {
        connect();
        doActivity();
        disconnect();
    }
}
