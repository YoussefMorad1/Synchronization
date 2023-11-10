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
        router.addConnection(this);
        System.out.println("Connection " + connectionId + ": " + name + " Occupied");
        System.out.println("Connection " + connectionId + ": " + name + " login");
    }

    public void doActivity() {
        System.out.println("Connection " + connectionId + ": " + name + " performs online activity");
    }

    public void disconnect() {
        System.out.println("Connection " + connectionId + ": " + name + " logout");
        router.removeConnection(this);
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
