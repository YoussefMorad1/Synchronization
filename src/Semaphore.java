class Semaphore {
    private int value;

    public Semaphore(int value) {
        this.value = value;
    }

    public synchronized void P(Device d) {
        value--;
        if (value < 0) {
            System.out.println(d.name + " (" + d.type + ") arrived and waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Semaphore.P() interrupted");
            }
        }
        else
            System.out.println(d.name + " (" + d.type + ") arrived");
    }

    public synchronized void V() {
        value++;
        if (value <= 0) {
            notify();
        }
    }
}
