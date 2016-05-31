package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

/**
 * @Author TPE_GRP_1
 */
public class Zug implements Runnable {
    private boolean running = true;
    private int geschwindigkeit;
    private char name;
    private int position;
    private Object printLock;

    private Strecke strecke;

    /**
     * zug constructor
     * position !< 0 && !>= strecke.length
     *
     * @param position        int
     * @param name            char
     * @param geschwindigkeit int
     * @param strecke         Strecke
     * @param printLock       Object
     */
    public Zug(int position, char name, int geschwindigkeit, Strecke strecke, Object printLock) {
        if(position < 0 || position >= strecke.length){
            System.err.println("Zug Darf nicht Außerhalb der Strecke Starten");
            this.position = 0;
        } else {
            this.position = position;
        }
        this.geschwindigkeit = geschwindigkeit;
        this.name = name;
        this.strecke = strecke;
        this.printLock = printLock;
        System.err.println("Zug "+getName()+" @ "+getPosition());
    }

    /**
     * Thread Zug wird gestartet;
     * Zug läuft pro sekunde seine Geschwindigkeit nach vorne und gibt bei jedem Schritt dem Printlock bescheid
     * Er hält an gesperrten Blocks an und
     */
    @Override
    public void run() {
        synchronized (printLock) {
            printLock.notify();
        }

        while (running) {

            Block block = strecke.array[position];
            Block nextBlock;

            nextBlock = (position >= strecke.length - 1) ? null : strecke.array[position + 1]; //Wenn letzte Pos in
            // Strecke dann nextBlock = null

            if (nextBlock != null && nextBlock.getStart() == position + 1 && nextBlock.isLocked()) {
                synchronized (nextBlock) {      //Wenn der nächste Block gesperrt ist Warte am Block
                    try {
                        while (nextBlock.isLocked()) {
                            nextBlock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (block != null) {
                if (block.getStart() == position) {             //Wenn Du auf einem Block StartPunkt Bist entsperre den
                    block.lock();                               // letzten Block und sprerre den jetzigen block
                    if (position > 0 && strecke.array[position - 1] != null) {  // beende dich und setze den Bisherigen Block frei
                        strecke.array[position - 1].unlock();
                    }
                }
            }

            position++;
            System.err.println("Zug "+getName()+" @ "+getPosition());
            synchronized (printLock) {                  //Gib dem Printlock bescheid und geh eine position Weiter
                printLock.notify();
            }


            if (this.position >= strecke.length) {          //Wenn deine Position Größer ist Als Streckenlänge
                if (strecke.array[position - 1] != null) {  // beende dich und setze den Bisherigen Block frei
                    strecke.array[position - 1].unlock();
                }
                running = false;
            } else {                                        //Ansonsten Warte 1sec/Geschwindikeit
                try {
                    Thread.sleep((1000 / geschwindigkeit));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public synchronized int getPosition() {
        return position;
    }

    public char getName() {
        return name;
    }

    public synchronized boolean getRunning() {
        return running;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    public synchronized Zug getZug() {
        return this;
    }


}
