package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;


/**
 * @Author TPE_GRP_1
 */
public class Block {

    private boolean locked;
    private int start;
    private int end;

    /**
     * constructor Block
     *
     * @param length int
     * @param start int
     */
    public Block(int length, int start) {
        this.start = start;
        this.end = start + length - 1;
    }

    public boolean isLocked() {
        return locked;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    /**
     * unlocks Block and notifys one Zug waiting at this Block
     */
    public void unlock() {
        synchronized (this) {
            notify();
        }
        locked = false;
    }

    /**
     * locks this Block
     */
    public synchronized void lock() {
        locked = true;
    }

}
