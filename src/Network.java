public class Network {
    public static void main(String[] args) {
        Router router = new Router(2);
        Device d1 = new Device("C1", "Laptop", router);
        Device d2 = new Device("C2", "Phone", router);
        Device d3 = new Device("C3", "Tablet", router);
        Device d4 = new Device("C4", "Pc", router);
        d1.start();
        d2.start();
        d3.start();
        d4.start();
    }
}