package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

/**
 * @Author TPE_GRP_1
 */
public class Strecke {

    int length;
    Block[] array;

    String strecke = "";

    /**
     * constructor Strecke
     *
     * @param length int
     */
    public Strecke(int length) {
        this.length = length;
        array = new Block[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * adds an Block to the block Array
     * Start & End must not collide with others or be overwritten
     *
     * @param block
     */
    public void addBlock(Block block) {

        array[block.getStart()] = block;
        array[block.getEnd()] = block;

    }

    /**
     * update the locks in the String
     */
    private void updateString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            if (array[i] != null && array[i].getStart() == i) {
                if (array[i].isLocked()) {
                    s += "|";                //Wenn isBlock und isLocked "|"
                } else {
                    s += "_";                //Wenn isBlock und isNotLocked "_"
                }
            } else {
                s += "-";
            }
        }
        strecke = s;
    }

    /**
     * at the beginning of an Simulation
     * if a train is in a Block this Block gets locked
     *
     * @param zuege
     */
    public void initLocks(Zug[] zuege) {
        for (Zug zug : zuege) {
            for (int i = zug.getPosition(); i > 0; i--) {
                if(i > this.length || i < 0){
                    System.err.println("Zug darf nicht außerhalb der Strecke starten");
                }
                if (array[i] != null && array[i].getStart() == i) {
                    array[i].lock();        //für jeden zug gehe von der position des zuges rückwärts bis du einen
                    break;                  // "StartBlock" findest dann sperre ihn
                }
            }
        }
        updateString();
    }

    /**
     * updates the string and returns it
     *
     * @return
     */
    public String getString() {
        updateString();
        return strecke;
    }

}
