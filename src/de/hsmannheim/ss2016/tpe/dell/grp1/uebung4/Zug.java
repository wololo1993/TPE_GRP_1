package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

public class Zug implements Runnable {
    private boolean running = true;
    private int geschwindigkeit;
    private char name;
    private int position;
    private Object printLock;

    private Strecke strecke;

    public Zug(int position, char name, int geschwindigkeit, Strecke strecke, Object printLock) {
        this.geschwindigkeit = geschwindigkeit;
        this.name = name;
        this.position = position;
        this.strecke = strecke;
        this.printLock = printLock;
    }


    @Override
    public void run() {
        synchronized (printLock) {
            printLock.notify();
        }

        while (running) {
            int count = geschwindigkeit;

            while (count > 0 && running) {

                Block block = strecke.array[position];
                Block nextBlock;
                if (position >= strecke.length - 1) {
                    nextBlock = null;
                } else {
                    nextBlock = strecke.array[position + 1];
                }

                if (nextBlock != null && nextBlock.getStart() == position + 1 && nextBlock.isLocked()) {
                    synchronized (nextBlock) {
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
                    if (block.getStart() == position) {
                        block.lock();
                        strecke.array[position - 1].unlock();
                    }
                }

                count--;


                synchronized (printLock) {
                    printLock.notify();
                }


                position++;


                if (this.position >= strecke.length) {
                    strecke.array[position - 1].unlock();
                    running = false;
                } else {
                    try {
                        Thread.sleep((1000 / geschwindigkeit));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
