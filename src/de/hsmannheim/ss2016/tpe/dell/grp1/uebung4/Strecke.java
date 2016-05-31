package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4;

public class Strecke {

    int length;
    Block[] array;

    String strecke = "";

    public Strecke(int length) {
        this.length = length;
        array = new Block[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public void addBlock(Block block) {

        array[block.getStart()] = block;
        array[block.getEnd()] = block;

    }

    private void updateString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            if (array[i] != null) {
                if (array[i].getStart() == i) {
                    if (array[i].isLocked()) {
                        s += "|";
                    } else {
                        s += "_";
                    }
                } else {
                    s += "-";
                }
            } else {
                s += "-";
            }
        }
        strecke = s;
    }

    public void initLocks(Zug[] zuege) {
        for (Zug zug : zuege) {
            for (int i = zug.getPosition(); i > 0; i--) {
                if (array[i] != null && array[i].getStart() == i) {
                    array[i].lock();
                    break;
                }
            }
        }
        updateString();
    }

    public String getString() {
        updateString();
        return strecke;
    }

}
