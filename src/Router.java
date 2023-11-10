import java.util.HashSet;

public class Router {
    Semaphore connections;
    final HashSet<Integer> connectionIds;

    public Router(int maxConnections) {
        connections = new Semaphore(maxConnections);
        connectionIds = new HashSet<>();
        for (int i = 1; i <= maxConnections; i++) {
            connectionIds.add(i);
        }
    }

    public void addConnection(Device d) {
        connections.P(d);

        // synchronized used to avoid getting the same connectionId for two devices
        synchronized (connectionIds) {
            int connectionId = connectionIds.iterator().next();
            connectionIds.remove(connectionId);
            d.setConnectionId(connectionId);
        }
    }

    public void removeConnection(Device d) {
        connectionIds.add(d.connectionId);
        connections.V();
    }
}
