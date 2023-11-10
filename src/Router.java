import java.util.HashSet;

public class Router {
    Semaphore connections;
    final HashSet<Integer> connectionIds;

    public Router(int maxConnections) {
        // TODO: Initialize connections and connectionIds
    }

    public void addConnection(Device d) {
        // TODO: Add connection to the router, use semaphore to limit the number of connections
    }

    public void removeConnection(Device d) {
        // TODO: Remove connection from the router, use semaphore to update the number of connections
    }
}
