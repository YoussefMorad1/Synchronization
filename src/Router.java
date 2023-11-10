import java.util.HashSet;

public class Router {
    Semaphore connections;
    final HashSet<Integer> connectionIds;

    //// Initialize connections and connectionIds
    public Router(int maxConnections) {
        connections = new Semaphore( maxConnections );  // gives the Semaphore the max capacity the router can deal with
        connectionIds = new HashSet <>();

        //assigns unique integer values representing connection IDs.
        for ( int i = 1 ; i <= maxConnections ; i++ ) {
            connectionIds.add( i );

        }

    }

    //// Add connection to the router, use semaphore to limit the number of connections
    public void addConnection(Device d) {
        //call  wait to check for available connections and wait if there are no available connections until a permit is available.
        connections.P( d );

        //because we have a limited number of connection ids

        // if all connections are currently in use, adding another would result in connectionIds  being empty.

        if (connectionIds.isEmpty()) {
            throw new IllegalStateException("No available connection IDs");
        }

        synchronized (connectionIds){
            int connectionId = connectionIds.iterator().next(); // retrieves the first available connection ID from connectionIds
            connectionIds.remove( connectionId );
            d.setConnectionId( connectionId );  //removes it from the set, and assigns it to the device d.

        }


    }

    /// Remove connection from the router, use semaphore to update the number of connections
    public void removeConnection(Device d) {

        //ensure that only one thread can modify the connectionIds set at a time
        synchronized (connectionIds) {
            connectionIds.remove(d.connectionId);
        }
        connections.V();
        // indicates that a connection has been released and can now be acquired by another device.

    }
}
